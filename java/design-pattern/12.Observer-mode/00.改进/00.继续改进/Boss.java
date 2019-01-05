import java.util.ArrayList;

class Boss implements ISubject{

    private String action ;
    
    ArrayList<Observer> observerList = new ArrayList<Observer>();
    
    @Override
    public void onAdd(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void onDetach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void onNotify() {
        for (Observer var : observerList) {

            var.onUpdate();
        }
    }

    @Override
    public String onGetAction() {
        return this.action;
    }

    @Override
    public void onSetAction(String action) {
        this.action = action;
    }
}