class test{
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl("jiaojiao");
        Proxy daili = new Proxy(jiaojiao);

        daili.giveChocolate();
        daili.giveDolls();
        daili.giveFlowers();
    }
}