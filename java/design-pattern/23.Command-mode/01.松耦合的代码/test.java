class test{
    public static void main(String[] args) {

        BarbecueCommand barbecueCommand = new BarbecueCommand();
        ChickenWingsCommand chickenWingsCommand = new ChickenWingsCommand();

        System.out.println("第一个顾客");
        Wait wait = new Wait();
        wait.onAdd(barbecueCommand);
        wait.onAdd(barbecueCommand);
        wait.onRemove(barbecueCommand);
        wait.onSure();

        System.out.println("第二个顾客");
        wait.onAdd(chickenWingsCommand);
        wait.onAdd(chickenWingsCommand);
        wait.onAdd(barbecueCommand);
        wait.onAdd(barbecueCommand);
        wait.onAdd(barbecueCommand);
        wait.onAdd(barbecueCommand);
        wait.onRemove(barbecueCommand);
        
    }
}