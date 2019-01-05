class FactorySqlserverUser implements IFactory{
    public IUser onCreateUser(){
        return new SqlserverUser();
    }

    public IDepartment onCreateDepartment(){
        return new SqlserverDepartment();
    }
}