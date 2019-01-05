class test{
    public static void main(String[] args) {
        Facade facade = new Facade() ;
        facade.facadeMethA();
        facade.facadeMethB();
        facade.facadeMethC();

        System.out.println("我们在使用的过程中，完全可以不用知道 三个子系统类的存在");
    }
}