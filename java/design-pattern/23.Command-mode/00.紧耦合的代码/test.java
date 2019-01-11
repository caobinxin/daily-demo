class test{

    public static void main(String[] args) {
        Barbecuer bar = new Barbecuer();

        bar.BakeMutton();
        bar.BakeChickenWing();

        bar.BakeChickenWing();
        bar.BakeChickenWing();
        bar.BakeChickenWing();
    }
}

/**
 * 
 * 存在的不足：
 *  客户端的程序和 烤肉串者，紧耦合， 代码僵化
 * 
 * 这个好比 路边的 流动 烤肉摊  乱七八糟的
 * 
 * 
 */