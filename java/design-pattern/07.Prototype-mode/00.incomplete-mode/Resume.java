class Resume{
    private String name ;
    private String sex ;
    private String age ;

    public Resume(String name){
        this.name = name ;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    public void onShow(){
        System.out.println(name + "->" + sex + "->" + age);
    }
}