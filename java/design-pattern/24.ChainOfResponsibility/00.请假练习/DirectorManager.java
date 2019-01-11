class DirectorManager extends Manager{
    public DirectorManager(String name){
        super(name);
    }

    @Override
    public void onApproval(String context) {
        if(context.equals(Com.Please_two_day)){
            System.out.println(name + " 批准 " + context);
        }else{
            if( upManager != null){
                upManager.onApproval(context);
            }
        }
    }
}