class test {
    public static void main(String[] args) {
        User cbx = new User("曹斌鑫", "19");
        User cy = new User("陈阳", "20") ;

        IFactory dbb = new FactorySqlserverUser();
        IUser db = dbb.onCreateUser();

        db.onInsert(cbx);
        db.onGetUser(2);

        db.onInsert(cy);
        db.onGetUser(3);
    }
}


/**
 * 　这里用　工厂方法模式进行改进后，我们可以很灵活的对　db数据库进行替换了
 * 
 * 
 *  这样就完成了　业务逻辑和数据访问的解耦
 * 
 * 
 *  这种设计依然存在问题：　新的需求，　我们要在　数据库中　在增加一个　部门表　该如何做呢！
 */