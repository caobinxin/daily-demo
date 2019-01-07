class Adepter implements Target{
    
    private Adeptee adeptee = new Adeptee();
    
    @Override
    public void onRequest() {
        adeptee.hello();
    }
}

/**
 * 
 * 这个就是适配器类　　向外提供　onRequest -> hello　的转换
 */