class PersionDirector{

    PersionBuilder persionBuilder = null ;

    public PersionDirector(PersionBuilder persionBuilder){
        this.persionBuilder = persionBuilder;
    }

    public void createPersion(){
        persionBuilder.onBuildArmLeft();
        persionBuilder.onBuildArmRight();
        persionBuilder.onBuildBody();
        persionBuilder.onBuildHead();
        persionBuilder.onBuildArmLeft();
        persionBuilder.onBuildArmRight();
    }
}