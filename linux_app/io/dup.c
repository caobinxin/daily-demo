#include <stdio.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(int argc, const char *argv[])
{
	
	int fd1 ;

	if( argc != 2)
	{
		printf("Usage: %s filename\n", argv[0]) ;
		return 1 ;
	}

	if( ( fd1 = open( argv[1], O_CREAT | O_RDWR, 0777)) == -1)
	{
		perror("Cannot create the file") ;
		return 1 ;
	}

	close(STDOUT_FILENO) ;

	if( dup( fd1) == -1)
	{
		perror("Cannot reserved the std out fd") ;
		return 1 ;
	}

	printf("Write the the file\n") ;
	
	close(fd1) ;

	return 0;
}
