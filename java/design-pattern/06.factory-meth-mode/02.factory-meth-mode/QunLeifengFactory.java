class QunLeifengFactory implements IFactory{
    
    public QunLeifengFactory(){
        System.out.println("QunLeifengFactory");
    }

    @Override
    public ILeiFeng onCreateLeifeng() {
        return new QunLeifeng();
    }
}