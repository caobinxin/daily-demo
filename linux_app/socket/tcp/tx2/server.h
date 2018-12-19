#ifndef __SERVER_H__
#define __SERVER_H__

#define POST 3333

#define FILE_BUF_SIZE 1024
#define CMD_BUF_SIZE 16

#define CLIENT_TYPE_DEFAULT 0
#define CLIENT_TYPE_UPLOAD 1

#define SEV_READYED_RECEIVE_FILE "sev_readyed_receive_file\n"
#define SEV_INQUIRY_UPLOAD_FILE_SIZE "inquiry_upload_file_size\n"

extern void handle_child_process(int client_fd);
extern int upload_client(int client_fd);
extern long inquiry_upload_file_size(int client_fd);

#endif