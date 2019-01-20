import java.util.ArrayList;

class test{
    public static void main(String[] args) {
        
        ContextC contextC = new ContextC();
        ArrayList<AbstractExpression> list = new ArrayList<AbstractExpression>();

        
        
        list.add(new TerminalExpression());
        list.add(new NonteminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());

        for ( AbstractExpression var: list) {
            var.onInterpret(contextC);
        }

     

    }
}