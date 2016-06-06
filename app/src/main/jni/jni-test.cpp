#include "win_yulongsun_androidsample_jni_JniTest.h"

JNIEXPORT jstring JNICALL Java_win_yulongsun_androidsample_jni_JniTest_get(JNIEnv *env,jobject obj){
    return (*env).NewStringUTF("This is Jni Lib");
}