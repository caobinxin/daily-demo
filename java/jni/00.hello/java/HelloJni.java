
public class HelloJni
{
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
        System.out.println("" + stringFromJNI());
    }

    public static native String  stringFromJNI();

    public static native String  unimplementedStringFromJNI();

    static {
        System.loadLibrary("hello-jni");
    }
}