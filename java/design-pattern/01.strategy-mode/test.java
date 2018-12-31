class test{
    public static void main(String[] args) {
        CashContext cContext = null ;
        cContext = new CashContext(new CashReturn("100", "50")) ;/*注册*/
        System.out.println(cContext.getResult(300));/*回调 */
        
    }
}