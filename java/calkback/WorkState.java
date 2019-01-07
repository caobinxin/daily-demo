class WorkState implements IStatue{
    @Override
    public void onWork(WorkTest tt) {
        

        try {
            System.out.println("11111111111111111");
            tt.iStatue = null;
            System.out.println("2222222222222222");
            Thread.sleep(3000);
            System.out.println("3333333333");
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e.getMessage());
        }
    }
}