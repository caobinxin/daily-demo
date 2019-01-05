class SqlserverUser implements IUser{

    public SqlserverUser(){
        System.out.println("SqlserverUser");
    }

    @Override
    public User onGetUser(int id) {
        System.out.println("id:" + id);
        return null;
    }

    @Override
    public void onInsert(User user) {
        System.out.println("User name = " + user.getName() + "  age :" + user.getAge());    
    }
}