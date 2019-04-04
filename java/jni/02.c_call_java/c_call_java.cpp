#include "c_call_java.h"
#include <string>
#include <string.h>
#include <stdlib.h>
 
// 由于jvm和c++对中文的编码不一样，因此需要转码。 utf8/16转换成gb2312
char* jstringToChar(JNIEnv* env, jstring jstr);

JNIEXPORT jstring JNICALL JNICALL Java_CCallJava_callC(JNIEnv *env, jobject jobj){
    //修改普通成员变量
    jclass jclazz = env->GetObjectClass(jobj);
    jfieldID jfieilId = env->GetFieldID(jclazz, "anInt", "I");
    jint anInt = 35;
    env->SetIntField(jobj, jfieilId, anInt);
 
    //修改静态成员变量
    jfieldID jstaticFieldId = env->GetStaticFieldID(jclazz, "anIntS", "I");
    env->SetStaticIntField(jclazz, jstaticFieldId, 55);
 
    //通过jni调用普通java方法
    jmethodID  jmethodId = env->GetMethodID(jclazz, "test", "()V");
    env->CallVoidMethod(jobj, jmethodId);
 
    //通过jni调用静态java方法
    jmethodID jstaticMethodId = env->GetStaticMethodID(jclazz, "staticTest", "(I)V");
    env->CallStaticVoidMethod(jclazz, jstaticMethodId, 55);
 
    //通过jni调用java中带参方法
    jmethodID methodId = env->GetMethodID(jclazz, "test", "(ILjava/lang/String;)Ljava/lang/String;");
    jstring str = env->NewStringUTF("小丽");
    env->CallObjectMethod(jobj, methodId, 18, str);
    
    //通过jni调用其他类中的方法
    jfieldID sonJfieldId = env->GetFieldID(jclazz, "son", "LSon;");//这里要注意一点 引用的签名前要加L
    jobject sonJobj = env->GetObjectField(jobj, sonJfieldId);
    jclass sonClazz = env->GetObjectClass(sonJobj);
    jmethodID sonMethodId = env->GetMethodID(sonClazz, "eye", "()V");
    env->CallVoidMethod(sonJobj, sonMethodId);
 
    //通过jni调用父类中的方法
    jclass jfatherClazz = env->GetSuperclass(sonClazz);
    jmethodID jfatherMethodId = env->GetMethodID(jfatherClazz, "eye", "()V");
    env->CallNonvirtualVoidMethod(sonJobj, jfatherClazz, jfatherMethodId);

    //通过jni实例父类的构造方法
    jmethodID fatherNewMethodId = env->GetMethodID(jfatherClazz, "<init>", "()V");
    jobject fatherJobj = env->NewObject(jfatherClazz, fatherNewMethodId);
    //获取父类中的属性fatherName
    jfieldID fatherFieldId = env->GetFieldID(jfatherClazz, "fatherName", "Ljava/lang/String;");
    jstring fatherName = env->NewStringUTF("My name is 张三");
    //修改fatherName的值为My name is 张三
    env->SetObjectField(fatherJobj, fatherFieldId, fatherName);
    jmethodID fatherGetNameId = env->GetMethodID(jfatherClazz, "getFatherName", "()Ljava/lang/String;");
    //调用父类中的getFatherName方法，获取属性值
    fatherName = (jstring) env->CallObjectMethod(fatherJobj, fatherGetNameId);
#if 1
    //转换的　方案一
    char* resultName = jstringToChar(env, fatherName);
    printf("%s\n", resultName);
#else
    //对java中的String 转换成　native字符串的　方案二
    char *resultName = env->GetStringUTFChars(fatherName, NULL) ;
    printf("%s\n", resultName);
    env->ReleaseStringUTFChars(fatherName, resultName) ;
#endif
 
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
 
// 由于jvm和c++对中文的编码不一样，因此需要转码。 utf8/16转换成gb2312
char* jstringToChar(JNIEnv* env, jstring jstr) {
    char* rtn = NULL;
    jclass clsstring = env->FindClass("java/lang/String");
    jstring strencode = env->NewStringUTF("UTF-8");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte* ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char*) malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
    return rtn;
}