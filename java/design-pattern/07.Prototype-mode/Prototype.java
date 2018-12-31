abstract class Prototype{

    private String id ;
    private String age ;
    private String company ;

    public Prototype(String id){
        this.id = id ;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }
    
    public abstract Prototype Clone();
}