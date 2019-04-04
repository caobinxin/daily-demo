#include "c_call_java_array.h"
#include <string>
#include <string.h>

JNIEXPORT jstring JNICALL Java_ArraysJava_stringFromJNI(JNIEnv * env, jobject jobj)
{
    jclass clz = env->GetObjectClass(jobj);
    jfieldID arrayFieldId = env->GetFieldID(clz, "arrays", "[I");
    jintArray jiarray = (jintArray) env->GetObjectField(jobj, arrayFieldId);
    jint* arrays = env->GetIntArrayElements(jiarray, NULL);
    jsize jIntSize = env->GetArrayLength(jiarray);
    printf("Java_ArraysJava_stringFromJNI ...\n") ;
    for (int i = 0; i < jIntSize; ++i) {
        printf("%d ", arrays[i]);
    }
    printf("\n") ;
    env->ReleaseIntArrayElements(jiarray, arrays, 0); //一但进行绑定就必须进行释放
 
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT void JNICALL Java_ArraysJava_arraysFromJava(JNIEnv *env, jobject jobj, jintArray arrays_)
{
      //获取到数组指针
    jint* arrays = env->GetIntArrayElements(arrays_, NULL);
    printf("Java_ArraysJava_arraysFromJava ...\n") ;
    //获取数组长度
    jsize arraysSize = env->GetArrayLength(arrays_);
    for (int i = 0; i < arraysSize; ++i) {
        printf("%d", arrays[i]);
    }
    printf("\n") ;

    env->ReleaseIntArrayElements(arrays_, arrays, 0);
 
    //复制数组（将arrays_里面的内容复制到newArrays里）
    printf("将arrays_里面的内容复制到newArrays里...\n") ;
    jint newArrays[arraysSize];
    env->GetIntArrayRegion(arrays_, 0, arraysSize, newArrays);
    for (int i = 0; i < arraysSize; ++i) {
        printf("%d", newArrays[i]);
    }
    printf("\n") ;
}

JNIEXPORT void JNICALL Java_ArraysJava_testArray(JNIEnv *env, jobject jobj, jobjectArray testArrays)
{
    //通过指定索引位置获取对象
    jobject testObj = env->GetObjectArrayElement(testArrays, 2);//最后一个参数，设置获得数组中第几个元素
    jclass testClz = env->GetObjectClass(testObj);
    jmethodID testMethodId = env->GetMethodID(testClz, "test", "()V");
    env->CallVoidMethod(testObj, testMethodId);
    env->DeleteLocalRef(testObj); //对象使用完成后一定要释放对象引用

}