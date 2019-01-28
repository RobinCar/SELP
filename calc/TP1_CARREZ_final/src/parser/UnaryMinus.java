package parser;

import eval.State;

import java.io.IOException;

public class UnaryMinus extends Expression{

    Expression exp;

    public UnaryMinus(Expression exp) {
        this.exp = exp;
    }

    public String toString() {
        return "UnaryMinus(" + "-" + exp + ")";
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        return - exp.eval(s);
    }
}
