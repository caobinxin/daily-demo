class test{
    public static void main(String[] args) {
        Resume resume = new Resume("曹斌鑫");
        resume.setAge("12");
        resume.setOther("特变的话");
        resume.setCompany("公司A");

        Resume resume2 = (Resume)resume.Clone();
        // resume2.setAge("13");
        resume2.setCompany("公司B");

        // resume2.setOther("独自初始化");

        System.out.println(""+ resume.getId() + " " + resume.getAge() + " " + resume.getCompany() + " " + resume.getOther());
        System.out.println(""+ resume2.getId() + " " + resume2.getAge() + " " + resume2.getCompany() + " " + resume2.getOther());
        
    }
}