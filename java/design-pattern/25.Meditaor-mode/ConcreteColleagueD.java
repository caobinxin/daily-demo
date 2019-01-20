class ConcreteColleagueD extends Colleague{

    public ConcreteColleagueD(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void onNotify(String message) {
        System.out.println("ConcreteColleagueD -> 收到：" + message);
    }

    @Override
    public void onSend(String message) {
        System.out.println("ConcreteColleagueD -> 广播：" + message);
        mediator.onSend(message, this);
    }
}