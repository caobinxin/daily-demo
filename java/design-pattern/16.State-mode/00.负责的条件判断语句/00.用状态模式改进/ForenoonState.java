class ForenoonState implements IState{
    
    @Override
    public void onWork(Work work) {
        if( work.getHour() < 12){
            System.out.println("当前时间　" + work.getHour() + "上午工作，精神百倍");
        }else{
            work.setiState(new NoonState());
            work.WorkCode();
        }
    }
}