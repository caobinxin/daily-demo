
class test{
    public static void main(String[] args) {

        Secretary tongzhizhe = new Secretary() ;

        StockObserver tongshi1 = new StockObserver("曹斌鑫", tongzhizhe) ;
        StockObserver tongshi2 = new StockObserver("陈阳", tongzhizhe) ;


        tongzhizhe.attach( tongshi1);
        tongzhizhe.attach( tongshi2) ;

        tongzhizhe.setAction("老板回来了") ;
        tongzhizhe.onNotify();
    }
}

/**
 * 
 * 不足：
 *      前台类和观察者 耦合了
 *      1.前台类要增减观察者， 观察者需要前台的状态
 *      2.其他人 可以看 NBA 或者其他东东，不一定要全 炒股
 * 
 *      看00.改进版的代码
 * 
 *      首先是开放封闭原则，修改原有代码就说明设计不好。
 *      其次是依赖倒转原则，我们应该让程序都依赖抽象，而不是相互依赖
 * 
 */