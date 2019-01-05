class ObserverChi extends Observer{

    private String chi = "酸辣粉";
    
    public ObserverChi(String name, Secretary sub){
        super(name, sub);
    }
    
    @Override
    public void onWork() {
        System.out.println("停下当前吃" + chi);
    }
}