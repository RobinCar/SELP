package ast;

import eval.State;

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
    public String gen() {
        return "(" + exp1.gen() + Op.gen(op) + exp2.gen() + ")";
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        if(op == Op.MINUS) {
            return exp1.eval(s) - exp2.eval(s);
        }
        else if(op == Op.DIVIDE) {
            int val1 = exp1.eval(s);
            int val2 = exp2.eval(s);
            if(val2== 0)
                throw new ArithmeticException("Division by zero");
            else
                return val1 / val2;
        }
        else if(op == Op.PLUS) {
            return exp1.eval(s) + exp2.eval(s);
        }
        else if(op == Op.TIMES) {
            return exp1.eval(s) * exp2.eval(s);
        }
        else if(op == Op.EQUAL) {
            return exp1.eval(s) == exp2.eval(s) ? 1 : 0;
        }
        else if(op == Op.LESS) {
            return exp1.eval(s) < exp2.eval(s) ? 1 : 0;
        }
        else if(op == Op.MORE) {
            return exp1.eval(s) > exp2.eval(s) ? 1 : 0;
        }
        else if(op == Op.MOREOREQUAL) {
            return exp1.eval(s) >= exp2.eval(s) ? 1 : 0;
        }
        else if(op == Op.LESSOREQUAL) {
            return exp1.eval(s) <= exp2.eval(s) ? 1 : 0;
        }
        else if(op == Op.NOTEQUAL) {
            return exp1.eval(s) != exp2.eval(s) ? 1 : 0;
        }
        else if(op == Op.AND) {
            return (exp1.eval(s) != 0 && exp2.eval(s) != 0) ? 1 : 0;
        }
        else if(op == Op.OR) {
            return (exp1.eval(s) != 0 || exp2.eval(s) != 0) ? 1 : 0;
        }
        throw new ArithmeticException();
    }
}
