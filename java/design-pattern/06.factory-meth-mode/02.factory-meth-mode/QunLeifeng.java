class QunLeifeng implements ILeiFeng{
    public QunLeifeng(){
        System.out.println("QunLeifeng");
    }
    @Override
    public void onBuyRice() {
        System.out.println("buy rice");
    }

    @Override
    public void onSweep() {
        System.out.println("sweep");
    }

    @Override
    public void onWash() {
        System.out.println("wash");
    }
}