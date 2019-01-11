class test{
    public static void main(String[] args) {
        
        ConcreteAggregate a = new ConcreteAggregate();

        a.add("大鸟");
        a.add("小鸟");
        a.add("老外");
        a.add("公交车内部员工");
        a.add("小偷");

        System.out.println(a.getCount());

        Iterator i = new ConcreteIterator(a);
        Object item = i.onFirst();

        while (! i.onIsDone()) {
            System.out.println(i.onCurrentItem());
            i.onNext();
        }

    }
}