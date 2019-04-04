class Son extends Father{
    
    public Son(){
        super();
        System.out.println("Son ...");
    }
    @Override
    public void eye() {
        System.out.println("Son eye ...");
    }
}