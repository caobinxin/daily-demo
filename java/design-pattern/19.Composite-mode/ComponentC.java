class ComponentC{

    private String str = "";
    private String name = "";
    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }

    public ComponentC(String name){
        this.name = name;
    }
    
    public void onAdd(ComponentC c){
        System.out.println("Component.onAdd");
    }
    public  void onRemove(ComponentC c){
        System.out.println("Component.onRemove");
    }
    public  void onDisplay(int depth){
        for(int i = 0; i < depth; i++){
            str +="-";
        }
        System.out.println(str + " " + this.name);
    }
}