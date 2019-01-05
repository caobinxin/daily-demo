abstract class Observer{
    private String name ;
    private Secretary sub ;

    public Observer(String name, Secretary sub){
        this.name = name;
        this.sub = sub ;

    }

    public void onUpdate(){
        System.out.println( sub.getAction() + " "+ name );
        this.onWork();
    }

    public abstract void onWork();
}