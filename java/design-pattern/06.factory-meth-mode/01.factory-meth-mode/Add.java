class Add implements Ioperation{
    private int a, b ;

    public Add(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int operation(int a,int b) {
        System.out.println("加法");
        System.out.println("this.a =" + this.a + "  a=" + a);
        return this.a + this.b;

    }
}