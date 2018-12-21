#include <stdio.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, const char *argv[])
{
	pid_t pid, wait_pid ;
	int status ;

	pid = fork() ;

	if( pid == -1)
	{
		perror("cannot create new process") ;
		exit(1) ;
	}else if( pid == 0){
		printf("child process id: %ld\n", (long) getpid()) ;

		pause() ;
		_exit( 0) ;
	}else{
		
		do{
			wait_pid = waitpid( pid, &status, WUNTRACED | WCONTINUED) ;

			if( wait_pid == -1)
			{
				perror("cannot using waitpid function") ;
				exit(1) ;
			}

			if(WIFEXITED(status))
				printf("child process exites, status = %d\n", WEXITSTATUS(status)) ;

			if(WIFSIGNALED(status))
				printf("child process is killed by signal %d\n", WTERMSIG(status)) ;

			if(WIFSTOPPED(status))
				printf("child process is stopped by signal %d\n", WSTOPSIG(status)) ;

			if(WIFCONTINUED(status))
				printf("child process resume runing... \n") ;
		}while( !WIFEXITED(status) && !WIFSIGNALED(status)) ;

		exit(0) ;
	}
	return 0;
}