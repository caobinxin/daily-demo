import java.util.ArrayList;
import java.util.List;

class BarbecueMaster implements Master{

    private List<Object> foodlist;
    private Wait wait;
    public BarbecueMaster(Wait wait){
        this.wait = wait;
        foodlist = new ArrayList<Object>();
    }
    @Override
    public void onDo(String name) {
        System.out.println("烤肉师傅： 加一个 " + name);
        foodlist.add(name);
    }

    public void onSure(){
        onStartDo();
    }

    private void onStartDo(){
        for (Object var : foodlist) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println(e.getMessage());
            }
            
            wait.onNotify((String)var);
        }

        foodlist.clear();
        System.out.println("烤肉师傅 暂时 无事可做 foodlist = "+ foodlist.size());
    }
}