class ConcreteHandlerB extends Handler{
    @Override
    public void onHandleRequest(int value) {
        if( value > 10 && value <= 20){
            System.out.println("小于20");
        }else{
            if(handler != null){
                handler.onHandleRequest(value);
            }
        }
    }
}