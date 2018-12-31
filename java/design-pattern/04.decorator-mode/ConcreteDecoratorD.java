class ConcreteDecoratorD extends Decorator{

    @Override
    public void onOperation() {
        super.onOperation();
        System.out.println("装饰D");
    }
}