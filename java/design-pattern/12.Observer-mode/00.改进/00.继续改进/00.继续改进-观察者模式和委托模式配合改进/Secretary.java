import java.util.ArrayList;
class Secretary{
    
    private EventHandler eventHandler;
    
    public Secretary(){
        eventHandler = new EventHandler();
    }

    public void addListener(Object object, String methodName, Object... args){
        this.eventHandler.addEvent(object, methodName, args);
    }

    public void onNotify(){
        this.eventHandler.notityX();
    }
}