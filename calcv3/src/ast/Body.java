package ast;

import eval.State;

import java.io.IOException;
import java.util.List;

public class Body extends AST {

    private List<VarDef> defs;

    private Expression exp;

    public Body(List<VarDef> defs, Expression exp) {
        this.defs = defs;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Body(" + defs + " " + exp + ")";
    }

    @Override
    public String gen() {
        String ret = "";
        //ret.concat("{");
        for(VarDef var : defs) {
            ret = ret.concat("\n" + var.gen());
        }
        ret = ret.concat("\n" + exp.gen());
        //ret.concat("}");
        return ret ;
    }

    public int eval(State<Integer> s) throws IOException {
        for (VarDef f:defs){
            f.eval(s);
        }
        return this.exp.eval(s);
    }
}
