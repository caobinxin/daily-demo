class CCallJava{

    static int anIntS ;
    int anInt ;
    Son son = null;

    static{
        System.loadLibrary("CCallJava_jni");
    }

    public void test(){
        System.out.println("test ...");
    }

    public String test(int num, String str){
        System.out.println("String test(int num, String str) ... num:" + num + "  str:" + str);
        return "java test return";
    }
    
    public static void staticTest(int test){
        System.out.println("staticTest ...");
    }
    public native String callC();
}