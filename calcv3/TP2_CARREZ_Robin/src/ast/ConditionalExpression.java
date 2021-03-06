package ast;

import check.State;

import java.io.IOException;

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
    public String gen() {
        String ret = "";
        ret = ret.concat("if (" + exp1.gen() + ") {");
        ret = ret.concat("\n" + exp2.gen());
        ret = ret.concat("\n }");
        ret = ret.concat("else {");
        ret = ret.concat("\n" + exp3.gen());
        ret = ret.concat("\n }");
        return ret;
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        if(exp1.eval(s) == 0) return exp3.eval(s);
        else return exp2.eval(s);
    }
}
