abstract class Abstraction{

    protected Implementor implementor;

    /**
     * @param implementor the implementor to set
     */
    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    abstract void onOperation();
}