class CashContext {
    private CashSuper cSuper = null ;
    public CashContext(CashSuper cSuper){
        this.cSuper = cSuper ;
    }

    public double getResult(double money){
        return cSuper.acceptCash(money);
    }
}