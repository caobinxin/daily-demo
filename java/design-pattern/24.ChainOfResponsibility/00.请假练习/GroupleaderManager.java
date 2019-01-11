class GroupleaderManager extends Manager{
    public GroupleaderManager(String name){
        super(name);
    }

    @Override
    public void onApproval(String context) {
        if(context.equals(Com.Please_one_day)){
            System.out.println(name + " 批准了 你的 " + Com.Please_one_day);
        }else{
            if( upManager != null){
                upManager.onApproval(context);
            }
        }
    }
}