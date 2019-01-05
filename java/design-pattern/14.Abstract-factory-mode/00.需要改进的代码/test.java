class test{
    
    public static void main(String[] args) {
        User user = new User();

        SqlserverUser su = new SqlserverUser();

        su.insert(user) ;

        su.getUser(1);
    }
}


/**
 * 
 * 现在我们的需求是：　我们要将　SqlserverUser　换成其他的　数据库
 * 
 * 我们发现　　这段代码　存在　难以　替换的问题
 * 
 * 其他数据库的操作　和　sql数据库的操作，用法有很多不同的地方。
 * 
 * 插入操作和　查询操作　等一系列的操作，和具体的数据库绑定的太多
 * 
 * 这里之所以不能换数据库，原因就在于　sqlseverUser su = new SqlserverUser()
 * 使得　su这个对象被框死在sqlserver上了，　如果这里是灵活的，专业点的说法就是是多态的，那么在执行 su.insert(user) 和　
 * su.getUser() 时，就不用考虑是在用　sql server　还是用　access.
 * 
 * 
 * 这里可以用　工厂方法模式来封装　new sqlserverUser() 所造成的变化
 * 
 * 工厂方法模式是定义一个用于创建对象的接口，让子类决定实例化哪一个类
 * 
 */