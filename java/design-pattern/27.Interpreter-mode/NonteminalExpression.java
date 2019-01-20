/**
 * 对文法中的　每一条规则　R1 R2 R3 ... 都需要一个具体的非终端符，表达式，
 * 
 * 解释器　以递归方式　调用上面所提供的　代表R1 R2 ... 中各个符号的实例对象。
 */

class NonteminalExpression extends AbstractExpression{

    @Override
    public void onInterpret(ContextC context) {
        System.out.println("非终端　解释器");
    }
}