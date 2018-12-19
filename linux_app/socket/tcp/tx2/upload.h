#ifndef __UPLOAD_H__
#define __UPLOAD_H__

#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define CMD_UPLOAD "cmd_upload"
#define UPLOAD_ROOT_DIR "./"
#define UPLOAD_SAVE_DIR ""
#define UPLOAD_FILE_NAME "upload.zip"
#define UPLOAD_FILE_BUFF 512

extern int upload(int client_fd) ;


#endif