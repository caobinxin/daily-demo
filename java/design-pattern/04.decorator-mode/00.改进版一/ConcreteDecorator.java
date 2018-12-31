class ConcreteDecorator extends Decorator{

    private String name = null ;
    public ConcreteDecorator(String name){
        this.name = name ;
    }
    @Override
    public void onOperation() {
        super.onOperation();
        System.out.println("装饰 " + name);
    }
}