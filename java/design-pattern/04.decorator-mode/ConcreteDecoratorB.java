class ConcreteDecoratorB extends Decorator{

    private void B(){
        System.out.println("装饰B");
    }
    @Override
    public void onOperation() {
        super.onOperation();
        B();
    }
}