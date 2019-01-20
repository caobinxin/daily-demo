class ConcreteColleagueC extends Colleague{

    public ConcreteColleagueC(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void onNotify(String message) {
        System.out.println("ConcreteColleagueC -> 收到：" + message);
    }

    @Override
    public void onSend(String message) {
        System.out.println("ConcreteColleagueC -> 广播：" + message);
        mediator.onSend(message, this);
    }
}