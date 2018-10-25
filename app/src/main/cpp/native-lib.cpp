#include <jni.h>
#include <string>
#include <iostream>

using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_ollin_metodosnumericos_MethodSelectMain_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
