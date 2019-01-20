class ConcreteColleagueB extends Colleague{

    public ConcreteColleagueB(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void onNotify(String message) {
        System.out.println("ConcreteColleagueB -> 收到：" + message);
    }

    @Override
    public void onSend(String message) {
        System.out.println("ConcreteColleagueB -> 广播：" + message);
        mediator.onSend(message, this);
    }
}