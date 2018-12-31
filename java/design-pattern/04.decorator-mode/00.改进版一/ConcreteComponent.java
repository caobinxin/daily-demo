class ConcreteComponent implements Component{

    private String name = null ;

    public ConcreteComponent(String name){
        this.name = name ;
    }
    @Override
    public void onOperation() {
        System.out.println("姓名：" + name);
    }
}