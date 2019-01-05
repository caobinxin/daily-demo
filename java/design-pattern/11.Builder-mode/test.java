class test{
    public static void main(String[] args) {
        PersionThinBuilder thinPersion = new PersionThinBuilder() ;

        PersionDirector director = new PersionDirector(thinPersion);

        director.createPersion();


        PersionFanBuilder persionFanBuilder = new PersionFanBuilder();
        PersionDirector fanDirector = new PersionDirector(persionFanBuilder);

        fanDirector.createPersion();
    }
}