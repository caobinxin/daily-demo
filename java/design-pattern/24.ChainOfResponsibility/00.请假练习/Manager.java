abstract class Manager{
    protected String name;
    protected Manager upManager;
    public Manager(String name){
        this.name = name;
    }

    /**
     * @param upManager the upManager to set
     */
    public void setUpManager(Manager upManager) {
        this.upManager = upManager;
    }

    abstract public void onApproval(String context);
}