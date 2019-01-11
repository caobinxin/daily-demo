class RefinedAbstraction extends Abstraction{

    @Override
    void onOperation() {
        implementor.onOperationImp();
    }
}