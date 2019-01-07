class Guards extends Player{
    public Guards(String name){
        super(name);
    }

    @Override
    public void onAttack() {
        System.out.println("后卫 进攻" + name);
    }

    @Override
    public void onDefense() {
        System.out.println("后卫 防守" + name);
    }
}