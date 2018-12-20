#include "upload_client.h"
#include "debug.h"

int upload_client(int client_fd)
{
	int ret = -1;

	printf_run(" 文件上传客户端登录成功! \n") ;

	long file_size = inquiry_upload_file_size(client_fd) ;
	
	cmd_respond( client_fd,SEV_READYED_RECEIVE_FILE);
	int success = upload(client_fd, file_size) ;
	if( 0 == success){
		printf_run(" 上传成功!!!");
		cmd_respond(client_fd, SEV_UPLOAD_SUCCESS) ;

		decompression_exec_sh(client_fd) ;

		ret =  0 ;
	
	}else{
		printf_error(" 上传失败!!!") ;
		ret =  -1 ;
	}

	return ret ;
}

int upload(int client_fd, long file_size)
{
    int fd_w ;
    char save_file_name[128] = {0};
    int num ;
    char buffer[UPLOAD_FILE_BUFF] ;
    long current_size = 0 ;

    strcat(save_file_name, UPLOAD_ROOT_DIR) ;
    strcat(save_file_name, UPLOAD_FILE_NAME) ;
    printf_run("服务器段将要保存的目录:") ;
    printf_run(save_file_name) ;    

    if( ( fd_w = open( save_file_name, O_CREAT | O_WRONLY, 0777)) == -1)
	{
		perror("Cannot create the destination file") ;
		return 1 ;
	}

	while( (num = read( client_fd, buffer, UPLOAD_FILE_BUFF)) > 0)
	{
        current_size += num ;
		if( write( fd_w, buffer, num) == -1)
		{
			perror("Cannot write the fiel content to the file") ;
            close(fd_w);
			return 1 ;
		}

        if( current_size == file_size){
            printf_run("接收完毕！！！") ;
            break;
        }
	}

    close(fd_w) ;
    return 0 ;
}

long inquiry_upload_file_size(int client_fd)
{
	long file_size = 0 ;
	char buf[16] = {0} ;
	int len = 0 ;

	cmd_respond( client_fd,SEV_INQUIRY_UPLOAD_FILE_SIZE);
	len = read(client_fd, buf, 16);
	printf_run("上传的文件大小为：") ;

	file_size = atol(buf) ;
	printf("%ld\n", file_size) ;

	return file_size ;
}


int decompression_exec_sh(int client_fd)
{
	int ret = 0 ;
	pid_t pid, wait_pid ;
	int status ;

	ret = cmd_confirmation_request(client_fd, CLI_DECOMPRESSION_CMD) ;
	if( 0 != ret)
	{
		printf_error("处理异常，否则不执行\n") ;
		return -1 ;
	}

	//todo 执行

	printf_run(" 开始解压...\n") ;
	pid = fork() ;
	if( -1 == pid)
	{
		perror("cannot create new process decompression:") ;
		return -1 ;
	}else if( pid == 0){
		//todo 解压
		decompression() ;
	}else{
		wait_pid = waitpid( pid, &status, WUNTRACED | WCONTINUED) ;
		if( -1 == status)
		{
			perror("cannot using waitpid function") ;
			return -1 ;
		}else if( 0 == status){
			printf_run(" 解压成功!!!\n") ;
			return 0 ;
		}else{
			printf_warn(" 解压异常退出!!! 解压失败\n") ;
			return -1 ;
		}
	}
}

void decompression()
{
	int ret ;
	char dir_buf[128] = {0} ;

	getcwd(dir_buf, 128) ;

	printf_run(" 当前解压目录：\n") ;
	printf_warn(dir_buf) ;

	execlp("unzip", "unzip", UPLOAD_FILE_NAME, (char *)NULL) ;
}
