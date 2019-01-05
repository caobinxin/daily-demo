
class test{
    public static void main(String[] args) {

        Secretary tongzhizhe = new Secretary() ;

        ObserverStock tongshi1 = new ObserverStock("曹斌鑫", tongzhizhe) ;
        ObserverChi tongshi2 = new ObserverChi("陈阳", tongzhizhe) ;


        tongzhizhe.attach( tongshi1);
        tongzhizhe.attach( tongshi2) ;

        tongzhizhe.setAction("老板回来了") ;
        tongzhizhe.onNotify();
    }
}

/**
 * 
 *  在具体观察者中，和具体的类进行了耦合
 *      表现在 Observer 类中 出现了 具体的类  Secretary  
 * 
 *  我们要针对抽象进行编程，不应该这样写。 要将 Secretary继续进一步的抽象
 * 
 */