import java.util.ArrayList;
import java.util.List;

class Wait{

    private BarbecueMaster barbecueMaster;
    private List<Command> list ;
    public Wait(){
        barbecueMaster = new BarbecueMaster(this);
        list = new ArrayList<Command>();
    }

    public void onNotify(String name){
        System.out.println(name + "  已经做好，请吃");
    }

    private void notifyTodo(){
        if(list.size()>=6){
            onDoDo();
        }
    }

    public void onAdd(Command command){
        list.add(command);
        notifyTodo();
    }

    public void onRemove(Command command){
        list.remove(command);
    }

    public void onSure(){
        onDoDo();
    }

    private void onDoDo(){
        System.out.println("此时订单的数量是 list.size = " + list.size());
        for (Command var : list) {
            barbecueMaster.onDo(var.onEatWhat());
        }
        list.clear();
        System.out.println("此时已经在做了，不能取消了 List.size = " + list.size());
        barbecueMaster.onSure();
    }
}