import java.util.ArrayList;
import java.util.List;

class ConcreteMediator extends Mediator{
    
    private List<Colleague> colleagueList;

    public ConcreteMediator(){
        colleagueList = new ArrayList<Colleague>();
    }

    @Override
    public void onSend(String message, Colleague colleague) {
        for (Colleague var : colleagueList) {
            if( var != colleague){
                var.onNotify(message);
            }
        }
    }

    public void onAddColleague(Colleague colleague){
        colleagueList.add(colleague);
    }

}