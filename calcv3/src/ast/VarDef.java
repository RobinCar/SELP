package ast;

import check.State;

import java.io.IOException;

public class VarDef extends AST {

    private Variable var;

    public Variable getVar() {
        return var;
    }

    private Expression exp;

    public VarDef(Variable var, Expression exp) {
        this.var = var;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "VarDef(" + var + " = " + exp + ")";
    }

    @Override
    public String gen() throws IOException {
        return var.gen() + " = " + exp.gen() + ";";
    }

    public void check(State<Type> s) throws IOException {
        if(s.containsKey(var.getVar())) throw new IOException("Variable deja presente");
        s.bind(var.getVar(), exp.check(s));
    }
}
