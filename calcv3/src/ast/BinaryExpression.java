package ast;

import check.State;

import java.io.IOException;

public class BinaryExpression extends Expression {
    Op op;
    Expression exp1;
    Expression exp2;


    public BinaryExpression(Op op, Expression exp1, Expression exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public String toString() {
        return "BinaryExpression(" + exp1 + " " + op + " " + exp2 + ")";
    }

    @Override
    public String gen() throws IOException {
        return "(" + exp1.gen() + Op.gen(op) + exp2.gen() + ")";
    }

    @Override
    public Type check(State<Type> s) throws IOException {
        if(exp1.check(s) != exp2.check(s))
            throw new SemanticError("Opération sur des types différents");
        else if((op == Op.MINUS || op == Op.PLUS || op == Op.DIVIDE || op == Op.TIMES || op == Op.LESS || op == Op.LESSOREQUAL || op == Op.MORE || op == Op.MOREOREQUAL) && exp1.check(s) != Type.INT)
            throw new SemanticError("Opération arithmétique sur des booléens");
        else if((op == Op.OR || op == Op.AND) && exp1.check(s) != Type.BOOL)
            throw new SemanticError("Opération arithmétique sur des booléens");
        else if(op == Op.MINUS || op == Op.PLUS || op == Op.DIVIDE || op == Op.TIMES)
            return Type.INT;
        else if(op == Op.OR || op == Op.AND || op == Op.EQUAL || op == Op.LESS || op == Op.LESSOREQUAL || op == Op.MORE || op == Op.MOREOREQUAL || op == Op.NOTEQUAL)
            return Type.BOOL;
        else
            throw new SemanticError("Opération impossible");
    }
}
