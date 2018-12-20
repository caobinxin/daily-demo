#ifndef __SERVER_H__
#define __SERVER_H__

#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
# include <stdlib.h>

#define POST 3333

#define ROOT_DIR "/home/colby"

#define FILE_BUF_SIZE 1024
#define CMD_BUF_SIZE 16

#define CLIENT_TYPE_DEFAULT 0
#define CLIENT_TYPE_UPLOAD 1

extern void handle_child_process(int client_fd);
int daemon( int nochdir, int noclose);
void sig_handler( int signo);

#endif