class RoleStateManager{
    Memento memento;
    public RoleStateManager(Memento memento){
        this.memento = memento;
    }

    /**
     * @return the memento
     */
    public Memento getMemento() {
        return memento;
    }
}