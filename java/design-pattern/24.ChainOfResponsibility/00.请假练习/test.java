class test{
    public static void main(String[] args) {
        Manager gm = new GroupleaderManager("组长");
        Manager dm = new DirectorManager("经理");
        Manager ceo = new CEOManager("CEO");

        gm.setUpManager(dm);
        dm.setUpManager(ceo);

        // gm.onApproval(Com.Please_two_day);
        gm.onApproval(Com.Please_three_day);
    }
}