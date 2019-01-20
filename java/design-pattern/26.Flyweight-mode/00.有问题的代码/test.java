class test{

    public static void main(String[] args) {
        WebSite fx = new WebSite("产品展示");
        fx.use();

        WebSite fy = new WebSite("产品展示");
        fy.use();

        WebSite fz = new WebSite("产品展示");
        fz.use();

        WebSite fk = new WebSite("博客");
        fk.use();

        WebSite fl = new WebSite("博客");
        fl.use();

        WebSite fa = new WebSite("博客");
        fa.use();


    }

/**
 * 
 * 分析这段代码不合理的地方：
 * 
 *  如果我们做 三个产品展示 三个博客网站  就需要六个网站类的 实例 ，然而我们发现这六个实例  的代码都一样，  如果网站类型变多，此时就出现很多实例，
 *   随着实例的增多，对服务器的资源浪费  很严重
 * 
 * 每个对象的数据都不一样，如果实现 多个对象公用一套  代码？？？
 * 
 *  我们可以利用 用户的ID 的不同，来区分 不同的用户，具体的数据和模板 可以不同，但代码核心 和数据库 却是共享的。
 * 
 */
}