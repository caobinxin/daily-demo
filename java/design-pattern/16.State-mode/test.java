class test{
    public static void main(String[] args) {
        Context c = new Context(new ConcreteStateA()) ;

        c.onRequest();
        c.onRequest();
        c.onRequest();
        c.onRequest();
    }
}