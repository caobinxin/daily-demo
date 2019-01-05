class SleepingState implements IState{
    @Override
    public void onWork(Work work) {
        System.out.println("当前时间　" + work.getHour() + "不行了，睡着了");
    }
}