package ast;

import check.State;

public class Literal extends Expression {
    int val;

    public Literal(int val) {
        this.val = val;
    }

    public String toString() {
        return "Literal(" + val + ")";
    }

    @Override
    public String gen() {
        return Integer.toString(val);
    }

    @Override
    public Type check(State<Type> s) {
        return Type.INT;
    }
}
