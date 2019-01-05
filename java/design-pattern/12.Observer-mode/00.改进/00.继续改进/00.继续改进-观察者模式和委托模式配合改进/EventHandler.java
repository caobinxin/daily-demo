import java.util.ArrayList;

class EventHandler {
    private ArrayList<Event> eventlist ;
    public EventHandler(){
        this.eventlist = new ArrayList<Event>();
    }

    public void addEvent(Object object, String methodName, Object... params){
        Event event = new Event(object, methodName, params);
        this.eventlist.add(event);
    }

    public void deleEvent(Object object, String methodName, Object... params){
        Event event = new Event(object, methodName, params);
        this.eventlist.remove(event);
    }

    public void notityX() throws Exception{
        for (Event var : this.eventlist) {
            var.invoke();
        }
    }
}