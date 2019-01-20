class ConcreteUserA extends User{
    
    public ConcreteUserA(String name){
        super(name);
    }

    public void onOperation(Object context){
        System.out.println("ConcreteUserA onOperation object:" + context);
    }
}