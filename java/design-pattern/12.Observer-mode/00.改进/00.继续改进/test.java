
class test{
    public static void main(String[] args) {

        Secretary tongzhizhe = new Secretary() ;

        ObserverStock tongshi1 = new ObserverStock("曹斌鑫", tongzhizhe) ;
        ObserverChi tongshi2 = new ObserverChi("陈阳", tongzhizhe) ;


        tongzhizhe.onAdd( tongshi1);
        tongzhizhe.onAdd( tongshi2) ;

        tongzhizhe.onSetAction("老板回来了") ;
        tongzhizhe.onNotify();



        Boss boss = new Boss() ;

        tongshi1.setSub(boss);
        tongshi2.setSub(boss);

        boss.onAdd( tongshi1);
        boss.onAdd( tongshi2) ;

        boss.onSetAction("我回来了") ;
        boss.onNotify();

        System.out.println("------------dele object");
        boss.onDetach( tongshi2) ;

        boss.onSetAction("开除 tonshi2") ;
        boss.onNotify();
    }
}