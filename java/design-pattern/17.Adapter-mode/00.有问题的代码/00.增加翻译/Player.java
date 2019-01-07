abstract class Player{

    protected String name;

    public Player(String name){
        this.name = name;
    }

    public abstract void onAttack();
    public abstract void onDefense();

}