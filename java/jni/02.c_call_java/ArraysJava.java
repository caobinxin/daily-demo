class ArraysJava{

    int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Test[] testArrays = {
        new Test(), new Test(), new Test()
    };

    static{
        System.loadLibrary("CCallJavaArrays_jni");
    }
    
    public native String stringFromJNI();
 
    public native void arraysFromJava(int[] arrays);
 
    public native void testArray(Test[] testArrays);

}