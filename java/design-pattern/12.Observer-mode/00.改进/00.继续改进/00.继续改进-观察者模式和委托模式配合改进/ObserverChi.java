class ObserverChi{

    private String chi = "酸辣粉";
    private String name ;
    public ObserverChi(String name){
        this.name = name;
    }
    
    public void chi(String ll) {
        System.out.println(name + " 停下当前吃" + chi + " " + ll);
    }
}