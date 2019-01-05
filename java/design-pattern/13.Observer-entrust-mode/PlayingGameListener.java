import java.util.Date;

class PlayingGameListener{
    public PlayingGameListener(){
        System.out.println("playing...");
    }

    public void stopPlayingGame(Date data){
        System.out.println("stop playing " + data);
    }
}