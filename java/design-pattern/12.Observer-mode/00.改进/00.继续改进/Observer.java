abstract class Observer{
    private String name ;
    private ISubject sub ;

    public Observer(String name, ISubject sub){
        this.name = name;
        this.sub = sub ;

    }

    /**
     * @param sub the sub to set
     */
    public void setSub(ISubject sub) {
        this.sub = sub;
    }

    public void onUpdate(){
        System.out.println( sub.onGetAction() + " "+ name );
        this.onWork();
    }

    public abstract void onWork();
}