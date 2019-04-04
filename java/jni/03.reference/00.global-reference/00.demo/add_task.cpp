
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "add_task.h"
#include <memory>
#include <string>
#include <pthread.h>
#include <sys/prctl.h>


static JavaVM *javaVm = NULL;
static jobject call_java_job ;//c call java 时作为对象使用
static int base_num;

static void pthread_add_task(int num) ;

static int add_task(int num) ;

static void call_java(int sum) ;

JNIEXPORT void JNICALL Java_JavaMain_triggerCAddTask(JNIEnv *env, jobject job, jint num)
{
    
    printf("c: 接受到java下发的任务　num = %d   job = %p\n", num, (void *)job) ;

#define GLOBAL_JOBJECT
#ifdef GLOBAL_JOBJECT
    call_java_job = env->NewGlobalRef(job) ;//保存为一个全局的引用 ，用完记得释放
#else
    call_java_job = job ;这里我们不应该直接这样保存，
#endif

    pthread_add_task(num) ;
}

static int add_task(int num)
{
    int i;
    int sum ;
    
    for(i = 0, sum = 0; i <= num ; i++)
    {
        sleep(1) ;
        sum += i ;
    }

    return sum ;
}

void *task_thr_fn(void *args)
{
    int num, sum ;
    pid_t pid;
    pthread_t tid;

    pid = getpid();
    tid = pthread_self();
    printf("pid %u tid %u (0x%x)\n",(unsigned int) pid,(unsigned int) tid, (unsigned int) tid);

    sleep(1);
    num = (int)(*((int*)args));
    printf("pthread: num = %d\n", num) ;

    sum = add_task(num) ;
    printf("jni: sum = %d\n", sum) ;
    
    call_java(sum) ;

    return NULL;
}

static void pthread_add_task(int num)
{
    int err;
    pthread_t task;
    base_num = num ;
    err = pthread_create(&task, NULL, task_thr_fn, &base_num);
    if (err != 0)
        printf("can't create thread: \n");

    //这里不要阻塞，这里一旦阻塞住，就没意义了
    // pthread_join(task,NULL);//主线程将等待　task_thr_fn处理完后才返回

    printf("main thread exit.\n") ;
    
}

/**
 * call_java(sum) 
 * 当任务结束时，回调　java的 cEndOfTask()
*/

static void call_java(int sum)
{
    JNIEnv* env;

    jint ret = sum ;
    JavaVMAttachArgs args;

    args.version = JNI_VERSION_1_6;
    args.group = NULL;

    printf("AttachCurrentThread...\n") ;
    //2. 获得本线程的JNIEnv
    if (javaVm->AttachCurrentThread(&env, NULL) != JNI_OK) {
        printf("Attach failed\n");
        return ;
    }

    // jclass clasz = env->GetObjectClass(call_java_job) ;//这个是获取不到clasz
    jclass clasz = env->FindClass("JavaMain") ;
    jmethodID method_id = env->GetMethodID( clasz, "cEndOfTask","(I)I") ;

   
#ifdef GLOBAL_JOBJECT
    jobject object = call_java_job;
#else
 /*
    * 这个是创建一个java层的对象，如果用之前Java_JavaMain_triggerCAddTask中保存的对象去，调用java层的对象，JVM会奔溃
    *
    * */
    jobject object = env->AllocObject(clasz) ;
#endif

    jint ret_r = env->CallIntMethod(object, method_id, sum) ;

    printf("ret = %d\n", ret_r) ;

#ifdef GLOBAL_JOBJECT
    env->DeleteGlobalRef(call_java_job) ;//释放
#endif

    //3.释放这次JNIEnv
    if (javaVm->DetachCurrentThread() != JNI_OK) {
        printf("DetachCurrentThread failed\n");
    }

}

int JNI_OnLoad(JavaVM* vm, void* v) {
    //1. 保存全局的VM
    javaVm = vm;//一个进程只有一个，VM，将它保存下来，在c回传java的时候使用
    return JNI_VERSION_1_6;
}
