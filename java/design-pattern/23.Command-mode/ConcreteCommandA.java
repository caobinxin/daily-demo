class ConcreteCommandA extends Command{
    public ConcreteCommandA(Receiver receiver){
        super(receiver);
    }

    @Override
    public void onExecute() {
        receiver.onAction();
    }
}