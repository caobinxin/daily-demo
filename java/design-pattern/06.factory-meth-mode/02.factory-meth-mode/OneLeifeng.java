class OneLeifeng implements ILeiFeng{

    public OneLeifeng(){
        System.out.println("OneLeifeng");
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