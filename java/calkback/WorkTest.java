class WorkTest {
    public IStatue iStatue;
    public void invoke(){
        iStatue = new WorkState();
        iStatue.onWork(this);
    }
} 