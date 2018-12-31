class test{
    public static void main(String[] args) {
        TestPaper A = new StudentA();
        A.onTestQuestion1();
        A.onTestQuestion2();
        A.onTestQuestion3();

        TestPaper B = new StudentB();
        B.onTestQuestion1();
        B.onTestQuestion2();
        B.onTestQuestion3();
    }
}