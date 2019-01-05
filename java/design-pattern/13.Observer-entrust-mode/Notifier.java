abstract class Notifier{

    private EventHandler eventHandler = new EventHandler();

    /**
     * @return the eventHandler
     */
    public EventHandler getEventHandler() {
        return eventHandler;
    }

    /**
     * @param eventHandler the eventHandler to set
     */
    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public abstract void addListener(Object object, String methodName, Object...args) ;

    public abstract void notifyX();
}