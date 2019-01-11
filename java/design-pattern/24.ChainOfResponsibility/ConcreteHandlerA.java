class ConcreteHandlerA extends Handler{
    @Override
    public void onHandleRequest(int value) {
        if( value <= 10){
            System.out.println("小于等于 10");
        }else{
            if(handler != null){
                //如果不满足当前的处理 条件，就将这个处理过程 向下传递
                handler.onHandleRequest(value);// 在这个过程中处理 责任链的传递过程
            }
        }
    }
}