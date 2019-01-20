class ConcreteWebSite implements WebSite{
    
    private String name;
    private User user;
    public ConcreteWebSite(String name){
        this.name = name;
    }
    
    @Override
    public void onUse(String context) {
        System.out.println(name + ": " + context + "  objectAddr: " + this);

        if(null == user) return;
        System.out.println("user: " + user.toString());
        user.onOperation(this);
    }

    @Override
    public void onSetUser(User user){
        this.user = user;
    }
}