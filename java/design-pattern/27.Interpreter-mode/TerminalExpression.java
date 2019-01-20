
/**
 * 实现与文法中的终结符相关联的解释操作。
 */
class TerminalExpression extends AbstractExpression{
    @Override
    public void onInterpret(ContextC context) {
        System.out.println("终端解释器");
    }

}