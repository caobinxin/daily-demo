class Proxy implements GiveGift{

    private Pursuit shabi ;

    public Proxy(SchoolGirl schoolGirl){
        shabi = new Pursuit(schoolGirl);
    }

    @Override
    public void giveChocolate() {
        shabi.giveChocolate();
    }

    @Override
    public void giveDolls() {
        shabi.giveDolls();
    }

    @Override
    public void giveFlowers() {
        shabi.giveFlowers();
    }
}