package ast;

import check.State;

import java.io.IOException;
import java.util.List;

public class Body extends AST {

    private List<VarDef> defs;

    private Expression exp;

    private State<Type> s;

    public Body(List<VarDef> defs, Expression exp) {
        this.defs = defs;
        this.exp = exp;
        this.s = new State<Type>();
    }

    @Override
    public String toString() {
        return "Body(" + defs + " " + exp + ")";
    }

    @Override
    public String gen() throws IOException {
        this.check(s);
        String ret = "";
        ret = ret.concat("\n");
        ret = ret.concat( "#include <stdio.h>\n" +
                "int main () { \n");
        for(VarDef var : defs) {
            ret = ret.concat("\n" + s.lookup(var.getVar().getVar()) + " " + var.gen() + "\n");
        }
        ret = ret.concat("\nreturn printf(\"%d\\n\", \n\n" + exp.gen() + "\n\n);\n");
        ret = ret.concat("\n}");
        return ret ;
    }

    public void check(State<Type> s) throws IOException {
        for (VarDef f:defs){
            f.check(s);
        }
        this.exp.check(s);
    }
}
