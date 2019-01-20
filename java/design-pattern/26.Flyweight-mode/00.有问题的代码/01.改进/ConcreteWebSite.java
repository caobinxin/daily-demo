class ConcreteWebSite implements WebSite{
    
    private String name;
    public ConcreteWebSite(String name){
        this.name = name;
    }
    
    @Override
    public void onUse(String context) {
        System.out.println(name + ": " + context + "  objectAddr: " + this);
    }
}