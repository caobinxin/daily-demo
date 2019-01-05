class test {
    public static void main(String[] args) {
        User cbx = new User("曹斌鑫", "19");
        Department cbxDepartment = new Department("研发");
        User cy = new User("陈阳", "20") ;
        Department cyDepartment = new Department("陈阳");

        DataAccess dataAccess = new DataAccess();
       
        IUser db = dataAccess.onCreateUser();
        IDepartment iDepartment = dataAccess.onCreateDepartment();

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
 * 　这样就解决了　　批量替换的　问题
 * 
 *  但是这种方式依然不好，　　当我们增减　oracle　数据库的访问，本来抽象工厂只增加一个oraclefactory工厂类就可以了，现在就比较麻烦了。
 *  是的，没办法，这样就需要　在dataAccess类中　每个方法的switch 中加　case了。
 * 
 * 
 *  我们要考虑是就是　可不可以　不在程序里写明，　如果是sqlserver就去实例化　sqlSever数据库相关类，如果是access就去实例话access相关类　这样的语句，
 *  而是　根据字符串db的值　去某个地方　找应该要实例化的类是哪一个。这样，我们的switch 就可以对它说再见了。
 * 
 *  用依赖注入　的方式去解决　switch 问题。
 * 
 * 　利用反射机制，就可以很好的解决　
 * 
 * 
 */