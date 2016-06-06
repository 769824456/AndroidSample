package win.yulongsun.androidsample.jni;

/**
 * @Project AndroidSample
 * @Packate win.yulongsun.androidsample.jni
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/6/6
 * @Version 1.0.0
 * @Description
 */

public class JniTest {
    static {
        System.loadLibrary("jni-test");
    }

    public static void main(String[] args) {
        JniTest jniTest = new JniTest();
        System.out.println(jniTest.get());
        jniTest.set("hello jni");
    }


    public static native String get();

    public static native String set(String str);

}
