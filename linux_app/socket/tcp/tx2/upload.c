#include "upload.h"
#include "debug.h"
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
