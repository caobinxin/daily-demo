class Forwards extends Player{
    public Forwards(String name){
        super(name);
    }

    @Override
    public void onAttack() {
        System.out.println("前锋 进攻" + name);
    }

    @Override
    public void onDefense() {
        System.out.println("前锋 防守" + name);
    }

}