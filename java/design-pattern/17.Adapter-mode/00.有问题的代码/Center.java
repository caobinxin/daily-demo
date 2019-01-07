class Center extends Player{
    public Center(String name){
        super(name);
    }

    @Override
    public void onAttack() {
        System.out.println("中锋 进攻" + name);
    }

    @Override
    public void onDefense() {
        System.out.println("中锋 防守" + name);
    }
}