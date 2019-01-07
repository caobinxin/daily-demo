import java.util.ArrayList;
import java.util.List;

class ConcreteCompany extends Company{
    
    List<Company> listCompany;

    public ConcreteCompany(String name){
        super(name);
        listCompany = new ArrayList<Company>();
    }
    
    @Override
    public void onAdd(Company c) {
        listCompany.add(c);
    }

    @Override
    public void onDisplay(int d) {
        super.onDisplay(d);
        for (Company var : listCompany) {
            var.onDisplay( d + 2);
        }
    }

    @Override
    public void onRemove(Company c) {
        listCompany.remove(c);
    }

    @Override
    public void onLineOfDuty() {
        System.out.println(getName() + "   协调各个部门");
        for (Company var : listCompany) {
            var.onLineOfDuty();
        }
    }
}