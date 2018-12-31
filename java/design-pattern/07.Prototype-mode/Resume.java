class Resume extends Prototype{

    String other ;  /* 这个属性我们在clone中拷贝不了，   容许拷贝了都写到  拷贝后必须在次赋值 */

    /**
     * @param other the other to set
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * @return the other
     */
    public String getOther() {
        return other;
    }
    
    public Resume(String id){
        super(id) ;
    }

    @Override
    public Prototype Clone() {
        Prototype prototype = null ;
        
        prototype = new Resume(this.getId());
        prototype.setAge(this.getAge());
        prototype.setCompany(this.getCompany());

        return prototype;
    }
}