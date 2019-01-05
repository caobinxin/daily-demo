class NoonState implements IState{
    @Override
    public void onWork(Work work) {
        if( work.getHour() < 13){
            System.out.println("当前时间　" + work.getHour() + "饿了，　犯困　午休");
        }else{
            work.setiState(new AfternoonState());
            work.WorkCode();
        }
    }
}