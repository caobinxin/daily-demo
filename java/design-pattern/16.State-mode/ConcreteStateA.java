class ConcreteStateA extends State{
    @Override
    public void Handle(Context context) {
        /** */
        System.out.println("任务一　处理完");
        context.state = new ConcreteStateB();  
    }
}