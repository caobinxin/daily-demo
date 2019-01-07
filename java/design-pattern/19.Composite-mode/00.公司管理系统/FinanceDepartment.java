class FinanceDepartment extends Company{

    public FinanceDepartment(String name){
        super(name);
    }
    
    @Override
    public void onDisplay(int d) {
        super.onDisplay(d);
    }

    @Override
    public void onLineOfDuty() {
        System.out.println( getName() + "  公司财务收支管理");
    }
}