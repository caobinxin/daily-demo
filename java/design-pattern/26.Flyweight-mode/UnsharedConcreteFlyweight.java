class UnsharedConcreteFlyweight extends Flyweight{
    @Override
    public void onOperation(int extrinsicstate) {
        System.out.println("不共享的具体： Flyweight: " + extrinsicstate);
    }
}