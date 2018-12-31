class OneLeifengFactory implements IFactory{
    public OneLeifengFactory(){
        System.out.println("OneLeifengFactory");
    }

    @Override
    public ILeiFeng onCreateLeifeng() {
        return new OneLeifeng();
    }
}