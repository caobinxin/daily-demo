interface ISubject{
    public void onAdd(Observer observer);
    public void onDetach(Observer observer);
    public void onNotify();
    public String onGetAction();
    public void onSetAction(String action) ;
}