class JavaMain{

    static boolean runing = true ;

    static{
        System.loadLibrary("CAddTaskReturnJava_jni");
    }
    
    public static void main(String[] args) {
        System.out.println("java main ...");
        JavaMain javaMain = new JavaMain();
        System.out.println("javamain = " + javaMain);
        javaMain.triggerCAddTask(10);

        while(runing){
            //如果将下面的输出注销，while循环将不退出，如果放开当c 调用java时 将退出
            System.out.println("java while... runing = " + runing);
        }
    }

    //c 层处理完之后，回调java的函数
    public int cEndOfTask(int sum){
        System.out.println("java-cEndOfTask: sum = " + sum);
        runing = false ;
        return sum;
    }

    //触发c 去处理累加的任务
    public native void triggerCAddTask(int num);

}