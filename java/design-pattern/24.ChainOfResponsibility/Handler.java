abstract class Handler{
    protected Handler handler;
    
    /**
     * @param handler the handler to set
     */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    abstract public void onHandleRequest(int value);
}