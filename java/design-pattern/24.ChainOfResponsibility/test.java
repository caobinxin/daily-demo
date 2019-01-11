class test{
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandlerA();
        Handler h2 = new ConcreteHandlerB();
        Handler h3 = new ConcreteHandlerC();

        h1.setHandler(h2);
        h2.setHandler(h3);

        int[] intSet = {21, 3, 45, 67, 23, 11, 2, 3, 23, 14};

        for (int var : intSet) {
            h1.onHandleRequest(var);
        }
    }
}