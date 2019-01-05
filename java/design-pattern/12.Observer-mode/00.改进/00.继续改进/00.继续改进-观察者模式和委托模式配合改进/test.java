
class test{
    public static void main(String[] args) {

        ObserverChi cbx = new ObserverChi("caobinxin");
        ObserverStock cy = new ObserverStock("cy");
        Boss boss = new Boss();
        boss.addListener(cbx, "chi", "小伙子不错");
        boss.addListener(cy, "onStock", "不错哦");

        try {
            boss.notityX();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        
        
    }
}