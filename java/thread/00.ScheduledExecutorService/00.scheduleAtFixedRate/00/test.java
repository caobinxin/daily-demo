 
 import java.util.concurrent.*;

 class test{

    private static Runnable blockRunner = () -> {
        try {
            System.out.println("start blockRunner1");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("one round:" + "休眠2秒 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    private static Runnable blockRunner2 = () -> {
        try {
            System.out.println("start blockRunner2");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("one round:" + "休眠3秒 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    private static ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(4);

    public static void main(String ... args) {


        scheduledExecutorService.scheduleAtFixedRate(blockRunner, 0, 100, TimeUnit.MILLISECONDS);
        System.out.println("第2个");
        
        scheduledExecutorService.scheduleAtFixedRate(blockRunner2, 0, 100, TimeUnit.MILLISECONDS);

    }
 }


 /**
  * 
  结论就是，一个任务会被重复添加到一个延时任务队列，所以同一时间任务队列中会有多个任务待调度，线程池会首先获取优先级高的任务执行。如果我们的任务运行时间大于设置的调度时间，那么效果就是任务运行多长时间，调度时间就会变为多久，因为添加到任务队列的任务的延时时间每次都是负数，所以会被立刻执行
  */