class FactoryAccessUser implements IFactory{

    /** 工厂方法，　把创建的对象的过程进行了　统一化，　我们发现抽象可以使得我们的代码更加的统一化 */
    public IUser onCreateUser(){
        return new AccessUser();
    }

    public IDepartment onCreateDepartment(){
        return new AccessDepartment();
    }
    
}