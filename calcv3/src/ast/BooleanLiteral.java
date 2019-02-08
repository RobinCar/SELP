package ast;

import check.State;

public class BooleanLiteral extends Expression {

    private boolean bool;

    public BooleanLiteral(boolean bool) {
        this.bool = bool;
    }

    public String toString() {
        return "BooleanLiteral(" + bool + ")";
    }

    @Override
    public String gen() {
        if(bool) {
            return "1";
        }
        else {
            return "0";
        }
    }

    @Override
    public Type check(State<Type> s) {
        return Type.BOOL;
    }
}
