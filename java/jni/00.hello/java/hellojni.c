#include "hellojni.h"

JNIEXPORT jstring JNICALL Java_HelloJni_stringFromJNI
  (JNIEnv *env, jobject object){
      printf("jni-> stringFromJNI\n") ;

      return (*env)->NewStringUTF(env, "Hello from JNI !  Compiled with ABI ");
  }

JNIEXPORT jstring JNICALL Java_HelloJni_unimplementedStringFromJNI
  (JNIEnv *env, jobject object){
      printf("jni-> unimplementedStringFromJNI\n") ;

      return (*env)->NewStringUTF(env, "Hello from JNI !  Compiled with ABI ");
  }