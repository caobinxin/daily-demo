class HRDepartment extends Company{

    public HRDepartment(String name){
        super(name);
    }
    @Override
    public void onDisplay(int d) {
        super.onDisplay(d);
    }

    @Override
    public void onLineOfDuty() {
        System.out.println(getName() + "  员工培训管理");
    }
}