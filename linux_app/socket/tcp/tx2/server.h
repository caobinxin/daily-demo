#ifndef __SERVER_H__
#define __SERVER_H__

#define POST 3333

#define FILE_BUF_SIZE 1024
#define CMD_BUF_SIZE 16

#define SUCCESSED "successed"

extern void handle_child_process(int client_fd);

#endif