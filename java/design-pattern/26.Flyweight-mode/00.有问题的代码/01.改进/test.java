class test{
    public static void main(String[] args) {
        WebSiteFactory wf = new WebSiteFactory();
        String context = "干活";

        WebSite X = wf.onGetWebSite("产品展示");
        X.onUse(context);

        WebSite X1 = wf.onGetWebSite("产品展示");
        X1.onUse(context);

        WebSite X2 = wf.onGetWebSite("产品展示");
        X2.onUse(context);

        WebSite Y = wf.onGetWebSite("博客");
        Y.onUse(context);

        WebSite Y1 = wf.onGetWebSite("博客");
        Y1.onUse(context);

        WebSite Y2 = wf.onGetWebSite("博客");
        Y2.onUse(context);

    }
}

/**
 * 
 * 共享模式 和 单例模式 的区别
 * 
 * 单例模式 只能有一个对象的出现  
 * 
 * 而 共享模式可以做到  相同的ID下公用一个对象  不同ID下　对象不同。
 */



 /**
  * 这个代码还是有　问题：　　上面的代码只体现了　他们共享的部分，并没有体现　对象间的不同

        如果我们给多个企业建立网站　　他们的数据是不相同的，例如他们的账号是不同的，　该这么办？？？？


  */

  /**
   * 享元模式　可以避免大量非常相似的类的开销。　在程序设计中，有时需要生成大量细粒度的类实例来表示数据。如果能发现这些实例除了几个参数外基本上都是相同的，有时候就能够大幅度的减少需要实例化的类的数量。
   * 如果能把那些参数移到类实例的外面，在方法调用时将他们传递进来，就可以通过共享大幅度地减少单个实例的数目。
   * 
   * 也就是说　享元模式　Flyweight执行时所需要的状态是有内部的也可能有外部的，内部状态存储于　ConcreteFlyweight对象之中的，而外部对象则应该由客户端对象存储或计算，当调用flyweight对象的操作时，将该状态传递给它。
   * 
   * 
   * 
   */