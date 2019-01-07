class Memento{
    /** 为了保持 封装性，不应该给 属性提供 set 方法 */
    private int vitality;
    private int attack;
    private int defense;

    public Memento(int vitality, int attack, int defense){
        this.vitality = vitality;
        this.attack = attack;
        this.defense = defense;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }
    /**
     * @return the vitality
     */
    public int getVitality() {
        return vitality;
    }
}