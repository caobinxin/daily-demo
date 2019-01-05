class ObserverStock{
    
    private String name ;

    public ObserverStock(String name){
        this.name = name;
    }
    

    public void onStock(String stock) {
        System.out.println("关闭正在抄的股 " + stock);
    }
}