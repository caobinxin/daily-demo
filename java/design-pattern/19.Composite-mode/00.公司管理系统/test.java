class test{
    public static void main(String[] args) {
        ConcreteCompany bj = new ConcreteCompany("北京总部");
        bj.onAdd(new HRDepartment("北京财务部"));
        bj.onAdd(new FinanceDepartment("北京人力资源部"));

        ConcreteCompany mg = new ConcreteCompany("美国公司");
        mg.onAdd(new HRDepartment("美国财务部"));
        mg.onAdd(new FinanceDepartment("美国人力资源部"));

        ConcreteCompany wx = new ConcreteCompany("无锡公司");
        wx.onAdd(new HRDepartment("无锡人力资源部"));
        wx.onAdd(new FinanceDepartment("无锡财务部"));

        bj.onAdd(mg);
        bj.onAdd(wx);

        bj.onDisplay(0);
        bj.onLineOfDuty();
    }
}