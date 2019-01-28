package parser;

import lexer.Op;

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
        return "BinaryExpression(" + op + " " + exp1 + " " + exp2 + ")";
    }

    @Override
    public int eval() {
        if(op == Op.MINUS) {
            return exp1.eval() - exp2.eval();
        }
        else if(op == Op.DIVIDE) {
            if(exp2.eval() == 0)
                throw new ArithmeticException("Division by zero");
            else
                return exp1.eval() / exp2.eval();
        }
        else if(op == Op.PLUS) {
            return exp1.eval() + exp2.eval();
        }
        else if(op == Op.TIMES) {
            return exp1.eval() * exp2.eval();
        }
        else if(op == Op.EQUAL) {
            return exp1.eval() == exp2.eval() ? 1 : 0;
        }
        else if(op == Op.LESS) {
            return exp1.eval() < exp2.eval() ? 1 : 0;
        }
        return 0;
    }
}
