class SubFactory implements IFactory{
    @Override
    public Ioperation createIoperation() {
        return new Sub(1, 2);
    }
}