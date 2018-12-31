class AddFactory implements IFactory{
    @Override
    public Ioperation createIoperation() {
        return new Add(1, 2);
    }
}