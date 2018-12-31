class test{
    public static void main(String[] args) {

        ConcreteComponentQ Q = new ConcreteComponentQ() ;/**被装饰的物人 */

        ConcreteDecoratorA A = new ConcreteDecoratorA() ;/**装饰A */
        ConcreteDecoratorB B = new ConcreteDecoratorB() ;
        
        A.setComponent(Q) ;
        B.setComponent(A) ;

        B.onOperation();
        
    }
}