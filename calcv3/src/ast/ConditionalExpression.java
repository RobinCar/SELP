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
    public String gen() throws IOException {
        String ret = "";
        ret = ret.concat("( " + exp1.gen() + " ? " + exp2.gen() + " : " + exp3.gen() + " )");
        return ret;
    }

    @Override
    public Type check(State<Type> s) throws IOException {
        if(exp1.check(s) != Type.BOOL || (exp2.check(s) != exp3.check(s)))
            throw new SemanticError("Condition non valide");
        return exp2.check(s);
    }
}
