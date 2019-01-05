class RestState implements IState{
    @Override
    public void onWork(Work work) {
        System.out.println("当前时间　" + work.getHour() + "下班回家了");
    }
}