package parser;

public class ConditionalExpression extends Expression {
    Expression exp1;
    Expression exp2;
    Expression exp3;

    public ConditionalExpression(Expression exp1, Expression exp2, Expression exp3) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
    }

    public String toString() {
        return "ConditionalExpression(" + "if " + exp1 + " " + exp2 + " " + exp3 + ")";
    }

    @Override
    public int eval() {
        if(exp1.eval() == 0) return exp3.eval();
        else return exp2.eval();
    }
}
