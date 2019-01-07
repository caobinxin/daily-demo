class Memento{
    private String sex;
    private int id;

    public Memento(String sex, int id){
        this.sex = sex;
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }
}