class test{
    public static void main(String[] args) {
        int extrinsicstate = 22;

        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweight("X");
        fx.onOperation(--extrinsicstate);

        Flyweight fy = f.getFlyweight("Y");
        fy.onOperation(--extrinsicstate);

        Flyweight fz = f.getFlyweight("Z");
        fz.onOperation(--extrinsicstate);

        UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();
        uf.onOperation(--extrinsicstate);


        System.out.println("----------------测试String 底层实现是否　使用了享元模式------------------");

        String C = "caobinxin";
        String D = "caobinxin";
        System.out.println("如果地址相同说明　使用了　享元模式，　" + C==D);
    }
}

/**
 *  FlyweightFactory 根据 客户需求返回 早已生成好的对象，  这里是在 初始化 FlyweightFactory 时，就生成了 三个对象，我们也可以 在需要使用的时候，在初始化 那三个对象
 * 
 * 为什么会存在 unsharedConcreteFlyweight 的存在
 * 
 *  因为，尽管我们大部分时间都需要 共享对象来降低内存的损耗，但个别的时候也有可能不需要共享的，那么此时的UnsharedConcreteFlyweight 子类就有存在的必要了，它可以解决那些不需要共享的对象的问题
 * 
 * 
 * 
 */