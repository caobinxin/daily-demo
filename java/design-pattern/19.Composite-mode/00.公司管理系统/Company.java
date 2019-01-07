class Company{
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    public Company(String name){
        this.name = name;
    }

    public void onAdd(Company c){

    }

    public void onRemove(Company c){

    }

    public void onDisplay(int d){
        String str = "";
        for(int i=0; i < d; i++){
            str += "--";
        }

        System.out.println(str + " " + this.name);
    }

    public void onLineOfDuty(){

    }
}