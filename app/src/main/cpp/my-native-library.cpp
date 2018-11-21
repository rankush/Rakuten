#include <jni.h>

jint counter = 0;

extern "C" JNIEXPORT jint JNICALL
Java_com_example_ndktest_MainActivity_incrementCounter(
        JNIEnv *env,
        jobject /* this */) {
    return ++counter;
}
