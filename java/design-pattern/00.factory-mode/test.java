class test{
    public static void main(String[] args) {
        CashSuper cashSuper = CashFactory.createCashAccept("打8折");
        cashSuper.acceptCash(350);
        System.out.println(cashSuper.acceptCash(350));
    }
}