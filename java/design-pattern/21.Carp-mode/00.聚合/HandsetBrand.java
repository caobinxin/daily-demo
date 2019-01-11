abstract class HandsetBrand{
    
    protected HandsetSoft soft;

    /* 这其实是一种 桥接模式 */
    public void setHandsetSoft(HandsetSoft handsetSoft){ /* 仔细观察，后，  在两个抽象类之间我们建立的 聚合关系 */
        soft = handsetSoft;
    }

    public abstract void onRun();
}