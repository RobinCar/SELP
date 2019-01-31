package ast;

import eval.State;
import parser.SyntaxError;

import java.io.IOException;

public class VarDef extends AST {

    private Variable var;

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
    public String gen() {
        return null;
    }

    public void eval(State<Integer> s) throws IOException {
        if(s.containsKey(var.getVar())) throw new IOException("Variable deja presente");
        s.bind(var.getVar(), exp.eval(s));
    }
}
