class EveningState implements IState{
    @Override
    public void onWork(Work work) {
        
        if( work.isWorkFinished()){
            work.setiState(new RestState());
            work.WorkCode();
        }else{
            if(work.getHour() < 21){
                System.out.println("当前时间 " + work.getHour() + "加班哦，　疲惫之极");
            }else{
                work.setiState(new SleepingState());
                work.WorkCode();
            }
        }
    }
}
