class ForeignCenter{
    private String name;
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void 进攻(){
        System.out.println(name + " 中文进攻");
    }

    public void 防守(){
        System.out.println(name + " 中文防守");
    }
}