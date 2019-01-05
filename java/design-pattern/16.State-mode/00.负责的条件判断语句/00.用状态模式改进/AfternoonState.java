class AfternoonState implements IState{

    @Override
    public void onWork(Work work) {
        if( work.getHour() < 17){
            System.out.println("当前时间　" + work.getHour() + "下午状态还不错　继续努力");
        }else{
            work.setiState(new EveningState());
            work.WorkCode();
        }
    }
}