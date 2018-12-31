abstract class TestPaper{
    public void onTestQuestion1(){
        System.out.println("第1道题如下：");
        System.out.println("..............");
        System.out.println("答案：" + onAnswer1());
    }

    abstract String onAnswer1();

    public void onTestQuestion2(){
        System.out.println("第2道题如下：");
        System.out.println("..............");
        System.out.println("答案：" + onAnswer2());
    }

    abstract String onAnswer2();

    public void onTestQuestion3(){
        System.out.println("第3道题如下：");
        System.out.println("..............");
        System.out.println("答案：" + onAnswer3());
    }

    abstract String onAnswer3();
}