#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <errno.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>
#include <netdb.h>
#include "server.h"
#include "upload.h"
#include "debug.h"

void sig_handler( int signo)
{
	pid_t pid ;
	int stat ;

	pid = waitpid( -1, &stat, WNOHANG) ;
	while( pid > 0)
	{
		printf("child process terminated (PID:%ld)\n", (long) getpid()) ;
		pid = waitpid( -1, &stat, WNOHANG) ;
	}
	return ;
}

int main(int argc, const char *argv[])
{
	socklen_t clt_addr_len ;
	int listen_fd ;
	int com_fd ;
	int ret ;
	int i ;
	int len ;
	int port ;
	pid_t pid ;

	struct sockaddr_in clt_addr ;
	struct sockaddr_in srv_addr ;

	port = POST ;

	if( signal( SIGCHLD, sig_handler) < 0)
	{
		perror("cannot set the signal.") ;
		return 1 ;
	}

	listen_fd = socket(PF_INET, SOCK_STREAM, 0) ;
	if( listen_fd < 0)
	{
		perror("cannot create listening socket.") ;
		return 1 ;
	}

	memset( &srv_addr, 0, sizeof(srv_addr)) ;
	srv_addr.sin_family = AF_INET ;
	srv_addr.sin_addr.s_addr = htonl(INADDR_ANY) ;
	srv_addr.sin_port = htons(port) ;

	ret = bind( listen_fd, (struct sockaddr*)&srv_addr, sizeof(srv_addr)) ;
	if( -1 == ret)
	{
		perror("cannot bind server socket.") ;
		close(listen_fd) ;
		return 1 ;
	}
	
	ret = listen(listen_fd, 5) ;
	if( -1 == ret)
	{
		perror("cannot listen the client connect request") ;
		close( listen_fd) ;
		return 1 ;
	}

	while(1)
	{
		len = sizeof(clt_addr) ;
		printf_run("等待客户端连接...\n") ;
		com_fd = accept( listen_fd, (struct sockaddr*)&clt_addr, &len) ;
		printf_run("有新的客户端连接请求...\n") ;
		if( com_fd < 0)
		{
			if( EINTR == errno)
			{
				continue ;	
			}else{
				perror("cannot accept client connect request") ;
				close( listen_fd) ;
				return 1 ;
			}
		}

		pid = fork() ;
		if( pid < 0)
		{
			perror("cannot create the child process") ;
			close(listen_fd) ;
			return 1 ;
		}else if( 0 == pid){
			handle_child_process(com_fd) ;
			close( com_fd) ;
			return 0 ;
		}else{
			close(com_fd) ;
		}
	}
	return 0;
}

void handle_child_process(int client_fd)
{
	static char cmd_buf[CMD_BUF_SIZE] ;
	int len ;

	while(1)
	{
		len = read(client_fd, cmd_buf, CMD_BUF_SIZE);

		printf(" [client-%d]\n\t\trecv_buf_len=%d\n\t\trecv_buf=%s\n", getpid(),len, cmd_buf) ;

		if( '@' == cmd_buf[0]) break ;
		
		int client_type = CLIENT_TYPE_DEFAULT ;
		if(0 == strncmp(cmd_buf, CMD_UPLOAD, strlen(CMD_UPLOAD)))
		{
			client_type = CLIENT_TYPE_UPLOAD;
		}else{
			printf_warn(" unknown client type will close client_fd !\n") ;
			break;
		}

		switch(client_type)
		{
			case CLIENT_TYPE_UPLOAD:
				upload_client(client_fd) ;
				break;
			default:
				break;
		}

		break;

	}
	return ;
}

int cmd_respond(int client_fd, char* mm){
	if( (0 >= client_fd) || (NULL == mm))
	{
		printf_error(" client_fd error,or mm == NULL not cmd_respond...exit,") ;
		return -1 ;
	}

	write(client_fd, mm, strlen(mm)) ;
	printf_run(mm) ;

	return 0 ;
}

int upload_client(int client_fd)
{
	printf_run(" 文件上传客户端登录成功! \n") ;

	long file_size = inquiry_upload_file_size(client_fd) ;
	
	cmd_respond( client_fd,SEV_READYED_RECEIVE_FILE);
	int success = upload(client_fd, file_size) ;
	if( 0 == success){
		printf_run(" 上传成功!!!");
		return 0 ;
	
	}else{
		printf_error(" 上传失败!!!") ;
		return -1 ;
	}
}

long inquiry_upload_file_size(int client_fd)
{
	long file_size = 0 ;
	char buf[16] = {0} ;
	int len = 0 ;

	cmd_respond( client_fd,SEV_INQUIRY_UPLOAD_FILE_SIZE);
	len = read(client_fd, buf, 16);
	printf_run("上传的文件大小为：") ;
	printf_run(buf) ;

	file_size = atol(buf) ;
	printf("%ld\n", file_size) ;

	return file_size ;
}
