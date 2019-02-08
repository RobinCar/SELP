package ast;

import check.State;
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
    public Type check(State<Type> s) throws IOException {
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
