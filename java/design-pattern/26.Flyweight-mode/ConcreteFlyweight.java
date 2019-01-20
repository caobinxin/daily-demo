class ConcreteFlyweight extends Flyweight{

    @Override
    public void onOperation(int extrinsicstate) {
        System.out.println("具体 flyweight : " + extrinsicstate);
    }
}