package parser;

import eval.State;
import lexer.Identifier;

import java.io.IOException;
import java.util.List;

public class FunctionCall extends Expression {

    private Identifier func;

    private List<Expression> exps;

    public FunctionCall(Identifier func, List<Expression> exps) {
        this.func = func;
        this.exps = exps;
    }

    @Override
    public int eval(State<Integer> s) throws IOException {
        for(Expression exp : exps) {
            exp.eval(s);
        }
        return s.lookup(func.s);
    }

    @Override
    public String toString() {
        return "(" + func.s + " " + exps.toString() + ")";
    }
}
