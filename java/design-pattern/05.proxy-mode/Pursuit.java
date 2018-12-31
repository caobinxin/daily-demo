class Pursuit implements GiveGift{

    private SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl){
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveChocolate() {
        System.out.println("送巧克力");
    }

    @Override
    public void giveDolls() {
        System.out.println("送洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println("送鲜花");
    }
}