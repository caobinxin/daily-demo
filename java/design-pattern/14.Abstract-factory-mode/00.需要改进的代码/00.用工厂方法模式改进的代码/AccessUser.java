class AccessUser implements IUser{

    public AccessUser(){
        System.out.println("AccessUser ");
    }
    @Override
    public User onGetUser(int id) {
        System.out.println("id:" + id);
        return null;
    }

    @Override
    public void onInsert(User user) {
        /** 不同的数据库操作可以在这里体现出来 */
        System.out.println("User name = " + user.getName() + "  age :" + user.getAge());    
    }

    
}