package parser;

import java.util.List;

public class Head extends AST {

    private List<Variable> vars;

    public List<Variable> getVars() {
        return vars;
    }

    private Function func;

    public Head(List<Variable> vars, Function func) {
        this.vars = vars;
        this.func = func;
    }

    public Function getFunc() {
        return func;
    }

    @Override
    public String toString() {
        return "(" + func + " " + vars + ")";
    }
}
