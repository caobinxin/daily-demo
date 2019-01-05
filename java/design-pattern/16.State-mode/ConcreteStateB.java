class ConcreteStateB extends State{

    @Override
    public void Handle(Context context) {
        System.out.println("任务二处理完...");
        context.state = new ConcreteStateA();
    }
}