class GameRole{
    private int vitality;
    
    /**
     * @return the vitality
     */
    public int getVitality() {
        return vitality;
    }

    /**
     * @param vitality the vitality to set
     */
    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    private int attack;
    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @param attack the attack to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    private int defense;
    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }
    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void stateDisplay(){
        System.out.println("角色当前的状态：");
        System.out.println("体力 " + this.vitality);
        System.out.println("攻击力 " + this.attack);
        System.out.println("防御力 " + this.defense);
    }

    public void getInitState(){
        this.vitality = 100;
        this.attack = 100;
        this.defense = 100;
    }

    public void fight(){
        this.vitality = 0;
        this.attack = 0;
        this.defense = 0;
    }
}