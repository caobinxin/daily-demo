
import java.util.ArrayList;
import java.util.List;

class ConcreteAggregate extends Aggregate{
    private List<Object> items ;

    public ConcreteAggregate(){
        items = new ArrayList<Object>();
    }

    @Override
    public Iterator CreateIterator() {
        return new ConcreteIterator(this);
    }

    /**
     * @return the count
     */
    public int getCount() {
       return items.size();
    }

    public void add(Object object){
        items.add(object);
    }

    public Object getItems(int index){
       return items.get(index);
    }
}