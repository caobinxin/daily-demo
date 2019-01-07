class Translator extends Player{
    
    private ForeignCenter foreigncenter = new ForeignCenter();

    public Translator(String name){
        super(name);
        foreigncenter.setName(name);
    }
    @Override
    public void onAttack() {
        foreigncenter.进攻();
    }

    @Override
    public void onDefense() {
        foreigncenter.防守();
    }
}