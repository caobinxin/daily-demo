class test{
    public static void main(String[] args) {
        WebSiteFactory wf = new WebSiteFactory();
        String context = "干活";

        WebSite X = wf.onGetWebSite("产品展示");
        X.onSetUser(new ConcreteUserA("曹斌鑫"));
        X.onUse(context);

        WebSite X1 = wf.onGetWebSite("产品展示");
        X1.onSetUser(null);
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
  * 现在虽然　　可以　通过　传入　User 来做到　同一个ConcreteWebSite对象　不同的　数据，

    但还是有一个问题，就是　　同一个ConcreteWebSite对象　怎么去　处理　不同的　User的问题，　我认为这个问题还是很严重的。
  */