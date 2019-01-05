class Work{
    private int hour;
    private boolean WorkFinished = false;

    private IState iState;
    /**
     * @param iState the iState to set
     */
    public void setiState(IState iState) {
        this.iState = iState;
    }
    /**
     * @return the iState
     */
    public IState getiState() {
        return iState;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param workFinished the workFinished to set
     */
    public void setWorkFinished(boolean workFinished) {
        WorkFinished = workFinished;
    }

    public void WorkCode(){
        iState.onWork(this);
    }

    public Work(){
        this.iState = new ForenoonState();
    }

    /** 
     * @return the workFinished
     */
    public boolean isWorkFinished() {
        return WorkFinished;
    }
    
}