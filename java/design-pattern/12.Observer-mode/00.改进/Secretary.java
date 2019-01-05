import java.util.ArrayList;
class Secretary{

    private ArrayList<Observer> observerList = new ArrayList<Observer>();
    private String action ;

    public void attach(Observer observer){
        observerList.add(observer);
    }

    public void onNotify(){
        for (Observer var : observerList) {
            var.onUpdate();
        }
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }
}