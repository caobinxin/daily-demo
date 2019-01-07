class test{
    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        b.onAttack();

        Player m = new Guards("麦克格雷迪");
        m.onAttack();

        Player ym = new Translator("姚明");
        ym.onAttack();
        ym.onDefense();
    }
}

/**
 * 
 * 此时存在的问题是 姚明不知道 onAttack 和 onDefense 都是什么意思 需要翻译，该如何进行改造呢
 */