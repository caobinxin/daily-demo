class Boss {

    EventHandler eventHandler;

    public Boss(){
        eventHandler = new EventHandler();
    }
    
    
    public void addListener(Object object, String methodName, Object... args){
        this.eventHandler.addEvent(object, methodName, args);
    }

    public void notityX() throws Exception{
        this.eventHandler.notityX();
    }
}