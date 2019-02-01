package ast;

import eval.State;
import java.io.IOException;

public class Variable extends Expression {

    private String var;

    public String getVar() {
        return var;
    }

    public Variable(String var) {
        this.var = var;
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        return s.lookup(var);
    }

    @Override
    public String toString() {
        return "Variable(" + var + ")";
    }

    @Override
    public String gen() {
        return var;
    }
}
