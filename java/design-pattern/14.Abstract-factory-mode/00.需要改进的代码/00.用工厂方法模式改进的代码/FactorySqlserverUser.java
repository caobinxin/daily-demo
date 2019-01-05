class FactorySqlserverUser implements IFactory{
    public IUser onCreateUser(){
        return new SqlserverUser();
    }
}