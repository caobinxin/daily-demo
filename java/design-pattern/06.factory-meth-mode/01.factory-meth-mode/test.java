class test{
    public static void main(String[] args) {
        Ioperation ioperation = null;
        ioperation = new AddFactory().createIoperation();
        System.out.println("add: " + ioperation.operation(3, 4));

        ioperation = new SubFactory().createIoperation();
        System.out.println("sub: " + ioperation.operation(3, 4));
    }
}