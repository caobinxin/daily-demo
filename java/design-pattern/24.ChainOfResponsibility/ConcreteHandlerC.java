class ConcreteHandlerC extends Handler{
    @Override
    public void onHandleRequest(int value) {
        if( value > 20 && value <= 30){
            System.out.println("小于30");
        }else{
            System.out.println("大于30");
        }
    }
}