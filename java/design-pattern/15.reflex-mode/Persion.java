class Persion{
    
    private int id ;
    private String name;

    public Persion(){
    }

    public Persion(String name, int id){
        this.name = name;
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public String createNewName(String newName){
        String ret = name + newName;
        return ret;
    }

    private void testPrivate(int a){
        System.out.println("testPrivate a = " + a);
    }

    public void testParam(String tmp, int intTmp){
        System.out.println("tmp = " + tmp + "  intTmp = " + intTmp);
    }

    public static void testStaticMethod(int a){
        System.out.println("testStaticMethod a = " + a);
    }
}