class ConcreteDecoratorA extends Decorator{

    private void A(){
        System.out.println("装饰A");
    }
    @Override
    public void onOperation() {
        super.onOperation();
        A();
    }
}