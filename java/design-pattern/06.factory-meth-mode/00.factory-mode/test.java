class test{
    public static void main(String[] args) {
        Factory factory = new Factory();
        Ioperation ioperation ;
        ioperation = factory.createOperation("+");
        System.out.println("add: " + ioperation.operation(3, 4));

        ioperation = factory.createOperation("-");
        System.out.println("sub: " + ioperation.operation(4, 3));
    }
}