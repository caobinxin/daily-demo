import java.util.ArrayList;
class Secretary{

    private ArrayList<StockObserver> observerList = new ArrayList<StockObserver>();
    private String action ;

    public void attach(StockObserver observer){
        observerList.add(observer);
    }

    public void onNotify(){
        for (StockObserver var : observerList) {
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