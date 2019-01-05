import java.util.Date;

class WatchingTvListener{
    public WatchingTvListener(){
        System.out.println("watching tv");
    }

    public void stopWathingTv(String name, Date date){
        System.out.println(name + " stop watching " + date);
    }
}