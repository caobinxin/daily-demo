abstract class Colleague{
    protected Mediator mediator;
    abstract public void onSend(String message);
    abstract public void onNotify(String message);
}