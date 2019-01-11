class test{
    public static void main(String[] args) {
        Abstraction ab = new RefinedAbstraction();
        Implementor implementor = new ConcreteImplementorA();

        ab.setImplementor(implementor);
        ab.onOperation();

        ab.setImplementor(new ConcreteImplementorB());
        ab.onOperation();
    }
}