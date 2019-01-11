class CEOManager extends Manager{
    public CEOManager(String name){
        super(name);
    }

    @Override
    public void onApproval(String context) {
        System.out.println(name + " 不准 " + context + " 回去继续干活");
    }
}