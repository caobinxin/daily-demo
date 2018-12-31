class test{
    public static void main(String[] args) {

        ConcreteComponent Q = new ConcreteComponent("Q") ;/**被装饰的物人 */

        ConcreteDecorator A = new ConcreteDecorator("A") ;/**装饰A */
        ConcreteDecorator B = new ConcreteDecorator("B") ;
        
        A.setComponent(Q) ;
        B.setComponent(A) ;

        B.onOperation();
        
    }
}