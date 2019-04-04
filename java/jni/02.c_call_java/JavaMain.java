class JavaMain{
    public static void main(String[] args) {

        test1() ;
        // test2() ;

    }

    public static void test1(){
        System.out.println("\n\n\n\n");
        System.out.println("测试---------------c call java 普通调用-----------------------------------");
        CCallJava cCallJava = new CCallJava();
        cCallJava.son = new Son() ;
        String cRet = cCallJava.callC() ;
        System.out.println("anIntS=" + cCallJava.anIntS + " anInt=" + cCallJava.anInt + "  " + cRet);
        System.out.println("＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃");
        System.out.println("\n\n\n\n");
    } 

    public static void test2(){
        System.out.println("\n\n\n\n");
        System.out.println("测试---------------c call java 数组调用-----------------------------------");
        ArraysJava arraysJava = new ArraysJava();
        arraysJava.stringFromJNI();
        arraysJava.arraysFromJava(arraysJava.arrays);
        arraysJava.testArray(arraysJava.testArrays);
        System.out.println("＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃");
        System.out.println("\n\n\n\n");
    }
}