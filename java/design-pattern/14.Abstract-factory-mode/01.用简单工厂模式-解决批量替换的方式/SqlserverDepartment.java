class SqlserverDepartment implements IDepartment{

    private Department department;
    
    @Override
    public Department onGetDepartment() {
        System.out.println("部门：" + department.getName());
        return department;
    }

    @Override
    public void onInsert(Department department) {
        this.department = department;
        System.out.println("SqlserverDepartment 插入成功");
    }
} 