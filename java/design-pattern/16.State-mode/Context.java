class Context{
    public State state;

    public Context(State state){
        this.state = state;
    }

    public void onRequest(){
        System.out.println("" + this.state.getClass());
        this.state.Handle(this);
    }
}