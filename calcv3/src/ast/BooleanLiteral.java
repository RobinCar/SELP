package ast;

import eval.State;

import java.io.IOException;

public class BooleanLiteral extends Expression {

    private boolean bool;

    public BooleanLiteral(boolean bool) {
        this.bool = bool;
    }

    public String toString() {
        return "BooleanLiteral(" + bool + ")";
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        if(bool) return 1;
        else return 0;
    }
}
