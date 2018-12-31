class test{
    public static void main(String[] args) {
        IFactory iFactory = new OneLeifengFactory();
        ILeiFeng iLeifeng = iFactory.onCreateLeifeng();
        iLeifeng.onBuyRice();
        iLeifeng.onSweep();
        iLeifeng.onWash();

        iFactory = new QunLeifengFactory();/**修改的时候只需要修改这个 */
        iLeifeng = iFactory.onCreateLeifeng();
        iLeifeng.onBuyRice();
        iLeifeng.onSweep();
        iLeifeng.onWash();
    }
}