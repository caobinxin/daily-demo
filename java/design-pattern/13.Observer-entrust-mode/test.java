import java.util.Date;

class test{

    public static void main(String[] args) {
        
        Notifier goodNotifier = new ConcreteNotifier();

        PlayingGameListener playingGameListener = new PlayingGameListener();
        WatchingTvListener watchingTvListener = new WatchingTvListener();

        goodNotifier.addListener(playingGameListener, "stopPlayingGame", new Date()) ;
        goodNotifier.addListener(watchingTvListener, "stopWathingTv", "曹斌鑫", new Date()) ;

        goodNotifier.notifyX();

    }
}