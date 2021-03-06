package ast;

import check.State;

import java.io.IOException;

public class UnaryExpression extends Expression {

    Expression exp;

    Op op;

    public UnaryExpression(Expression exp, Op op) {
        this.exp = exp;
        this.op = op;
    }

    public String toString() {
        return "UnaryExpression(" + op + " " + exp + ")";
    }

    @Override
    public String gen() {
        return "(" + Op.gen(op) + exp.gen() + ")";
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        if(op == Op.MINUS) {
            return - exp.eval(s);
        }
        else {
            return exp.eval(s) == 0 ? 1 : 0;
        }
    }
}
