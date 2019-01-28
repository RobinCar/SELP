package parser;

import eval.State;
import lexer.Identifier;

import java.io.IOException;

public class Variable extends Expression {

    private Identifier var;

    public String getVar() {
        return var.s;
    }

    public Variable(Identifier var) {
        this.var = var;
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        return s.lookup(var.s);
    }

    @Override
    public String toString() {
        return "Variable(" + var.s + ")";
    }
}
