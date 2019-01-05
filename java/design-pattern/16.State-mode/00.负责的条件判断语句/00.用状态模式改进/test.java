class test{
    public static void main(String[] args) {
        Work work = new Work();
        work.setHour(4);
        work.WorkCode();

        work.setHour(12);
        work.WorkCode();

        work.setHour(15);
        work.WorkCode();

        work.setHour(16);
        work.setWorkFinished(true);
        work.WorkCode();

        work.setHour(18);
        work.setWorkFinished(false);
        work.WorkCode();


        work.setWorkFinished(false);
        work.setHour(23);
        work.WorkCode();
    }
}