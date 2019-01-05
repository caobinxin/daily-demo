class test{
    static private int hour;
    static private boolean WorkFinished = false;
    public static void main(String[] args) {
        hour = 9;
        onWork(); 

        hour = 14;
        onWork();

        hour = 20;
        onWork();

        WorkFinished = true;

        hour = 24;
        onWork();
    }

    static private void onWork(){
        if( hour < 12){
            System.out.println("当前时间　"+hour+"早上工作，精神百倍");
        }else if( hour < 13){
            System.out.println("当前时间　"+hour+"饿了，午饭，犯困，午休");
        }else if( hour < 17){
            System.out.println("当前时间　"+hour+"下午状态还不错，继续努力");
        }else{
            if(WorkFinished){
                System.out.println("当前时间　"+hour+"下班回家");
            }else{
                if( hour < 21){
                    System.out.println("当前时间　"+hour+"加班哦，疲累之极");
                }else{
                    System.out.println("当前时间　"+hour+"不行了，睡着了");
                }
            }
        }
    }
}