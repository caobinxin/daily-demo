class test{
    public static void main(String[] args) {
        CashContext cContext = null ;
        cContext = new CashContext("满300返100") ;/*注册*/
        System.out.println(cContext.getResult(300));/*回调 */
    }
}