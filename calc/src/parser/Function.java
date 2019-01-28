package parser;

import eval.State;
import lexer.Identifier;

import java.io.IOException;

public class Function extends Expression {

    private Identifier func;

    public Identifier getFunc() {
        return func;
    }

    public Function(Identifier func) {
        this.func = func;
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        return s.lookup(func.s);
    }

    @Override
    public String toString()  {
        return "Function(" + func.s + ")";
    }
}
