import java.util.ArrayList;
import java.util.List;

class Composite extends ComponentC{

    List<ComponentC> listComponentC;

    public Composite(String name){
        super(name);
        listComponentC = new ArrayList<ComponentC>();
    }
    @Override
    public void onAdd(ComponentC c) {
       listComponentC.add(c);
    }

    @Override
    public void onDisplay(int depth) {
        super.onDisplay(depth);
        for (ComponentC var : listComponentC) {
            var.onDisplay(depth + 6);
        }

    }

    @Override
    public void onRemove(ComponentC c) {
        listComponentC.remove(c);
    }
}