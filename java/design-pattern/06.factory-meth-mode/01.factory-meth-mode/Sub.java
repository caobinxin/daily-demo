class Sub implements Ioperation{
    
    private int a, b;
    public Sub(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int operation(int a, int b) {
        System.out.println("this.a =" + this.a + "  a=" + a);
        return this.a - this.b ;
    }
}