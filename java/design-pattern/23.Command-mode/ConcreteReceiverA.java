class ConcreteReceiverA extends Receiver{
    @Override
    public void onAction() {
        System.out.println("ConcreteReceiverA.onAction");
    }
}