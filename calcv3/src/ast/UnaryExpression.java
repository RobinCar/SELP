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
    public String gen() throws IOException {
        return "(" + Op.gen(op) + exp.gen() + ")";
    }

    @Override
    public Type check(State<Type> s) throws IOException {
        if(this.op == Op.MINUS && exp.check(s) == Type.INT)
            return Type.INT;
        else if(this.op == Op.NOT && exp.check(s) == Type.BOOL)
            return Type.BOOL;
        else throw new SemanticError("Type non valide");
    }
}
