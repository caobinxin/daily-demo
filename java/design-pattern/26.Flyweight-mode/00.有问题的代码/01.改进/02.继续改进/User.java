abstract class User{

    private String name;
    public User(String name){
        this.name = name;
    }

    abstract public void onOperation(Object context);
}