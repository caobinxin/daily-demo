public class TestShutdownHook {

    /**
     * @param args
     */
    public static void main(String[] args) {
     // 定义线程1
     Thread thread1 = new Thread() {
      public void run() {
       System.out.println("thread1...");
      }
     };
   
     // 定义线程2
     Thread thread2 = new Thread() {
      public void run() {
       System.out.println("thread2...");
      }
     };
   
     // 定义关闭线程
     Thread shutdownThread = new Thread() {
      public void run() {
       System.out.println("shutdownThread...");
      }
     };
   
     // jvm关闭的时候先执行该线程钩子
     Runtime.getRuntime().addShutdownHook(shutdownThread);
   
     thread1.start();
     thread2.start();
    }
   }

   /**
    * 无论是先打印thread1还是thread2，shutdownThread 线程都是最后执行的（因为这个线程是在jvm执行关闭前才会执行）。
    */