#include <stdio.h>
#include <malloc.h>

typedef int (*cmd_funcp)(int, ...) ;
typedef const char *cmd_exec_path ;
typedef const char *print_str ;

typedef struct{
    cmd_funcp cmd_func  ; 
    cmd_exec_path path ;
    print_str err_print_str ;
    print_str success_print_str ;
    int params_num ;
    char *params[];
} cmd_exec_t ;
/**
 * 
 * cmd_exec_t 中params不算空间大小，需要在malloc中分配大小，
 * 而且像这种定义只能放在　结构体的末尾定义，否则会报错
 * 
*/
cmd_exec_t * cmd_exec_p ;

int main(int argc, char const *argv[])
{
    int len = 10 ;
    printf("init before cmd_exec_p size = %ld\n", sizeof(*cmd_exec_p)) ;
    cmd_exec_p = (cmd_exec_t *)malloc(sizeof(*cmd_exec_p) + sizeof(char *)*len) ;
    cmd_exec_p->params_num = 10 ;

    printf("size = %ld\n", sizeof(*cmd_exec_p)) ;//之所以这里的结果和before cmd_exec_p size 相等是，我们malloc后做了强制类型装换
    printf("char * size = %ld\n", sizeof(char *)) ;

    for(int i = 0; i < cmd_exec_p->params_num; i++)
    {
        cmd_exec_p->params[i] = "abc" ;
    }

    for(int i = 0; i < cmd_exec_p->params_num; i++)
    {
        printf("%s\n", cmd_exec_p->params[i]) ;
    }
    return 0;
}