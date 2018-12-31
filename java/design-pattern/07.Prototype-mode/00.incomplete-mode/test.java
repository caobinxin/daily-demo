class test{
    public static void main(String[] args) {
        Resume resumeA = new Resume("曹斌鑫") ;
        resumeA.setAge("19");
        resumeA.setSex("男");


        Resume resumeB = resumeA;
        Resume resumeC = resumeB;

        resumeB.setAge("20");
        resumeC.setAge("21");

        resumeA.onShow();
        resumeB.onShow();
        resumeC.onShow();
    }
}