class Father{

    private String fatherName;

    public Father(){
        System.out.println("Father...");
    }

    public void eye(){
        System.out.println("father eye...");
    }

    public String getFatherName(){
        System.out.println("java::getFatherName->fatherName = " + fatherName);
        return "" + fatherName + "-java";
    }
}
