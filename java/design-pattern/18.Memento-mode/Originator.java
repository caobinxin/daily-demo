class Originator{

    private String name;
    private int id;
    private String sex;

    public Originator(String name, String sex, int id){
        this.name = name;
        this.sex = sex;
        this.id = id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Memento onCreateMemento(){
        Memento memento = new Memento(this.sex, this.id);
        return memento;
    }

    public void setMemento(Memento memento){
        this.id = memento.getId();
        this.sex = memento.getSex();
    }

    public void onShow(){
        System.out.println("姓名：" + this.name + " 性别：" + this.sex + " 身份证：" + this.id);
    }
}