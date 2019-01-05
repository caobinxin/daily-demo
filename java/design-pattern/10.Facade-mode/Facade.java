class Facade{
    private SubSystemOne subSystemOne;
    private SubSystemTwo subSystemTwo;
    private SubSystemThree subSystemThree;

    public Facade(){
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
    }

    public void facadeMethA(){
        subSystemOne.onOneMethA();
        subSystemTwo.onOneMethB();
    }

    public void facadeMethB(){
        subSystemOne.onOneMethC();
        subSystemTwo.onOneMethA();
        subSystemThree.onOneMethB();
    }

    public void facadeMethC(){
        subSystemOne.onOneMethB();
        subSystemTwo.onOneMethC();
        subSystemThree.onOneMethB();
    }
}