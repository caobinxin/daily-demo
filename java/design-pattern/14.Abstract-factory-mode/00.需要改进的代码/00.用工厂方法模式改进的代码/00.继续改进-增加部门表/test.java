class test {
    public static void main(String[] args) {
        User cbx = new User("曹斌鑫", "19");
        Department cbxDepartment = new Department("研发");
        User cy = new User("陈阳", "20") ;
        Department cyDepartment = new Department("文职");

        IFactory dbb = new FactoryAccessUser();
        IUser db = dbb.onCreateUser();
        IDepartment iDepartment = dbb.onCreateDepartment();

        db.onInsert(cbx);
        iDepartment.onInsert(cbxDepartment);
        db.onGetUser(2);
        iDepartment.onGetDepartment();

        db.onInsert(cy);
        iDepartment.onInsert(cyDepartment);
        db.onGetUser(3);
        iDepartment.onGetDepartment();
    }
}


/**
 * 　只有一个user类和　user操作类的时候，　是只需要工厂方法模式的，但现在显然你数据库中有很多的表，而sqlserver 和　access
 * 又是两大不同的分类。所以解决这种涉及到多个产品系列的问题，有一个专门的工厂模式叫做　抽象工厂模式
 */