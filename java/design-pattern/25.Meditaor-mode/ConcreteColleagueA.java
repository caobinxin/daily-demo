class ConcreteColleagueA extends Colleague{
    public ConcreteColleagueA(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void onNotify(String message) {
        System.out.println("ConcreteColleagueA -> 收到：" + message);
    }

    @Override
    public void onSend(String message) {
        System.out.println("ConcreteColleagueA -> 广播：" + message);
        mediator.onSend(message, this);
    }
}