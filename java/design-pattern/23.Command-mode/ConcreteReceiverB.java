class ConcreteReceiverB extends Receiver{
    @Override
    public void onAction() {
        System.out.println("ConcreteReceiverB.onAction");
    }
}