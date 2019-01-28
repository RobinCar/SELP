package ast;

import eval.State;

public class Literal extends Expression {
    int val;

    public Literal(int val) {
        this.val = val;
    }

    public String toString() {
        return "Literal(" + val + ")";
    }

    @Override
    public int eval(State<Integer> s) {
        return val;
    }
}
