package parser;

public class VarDef extends AST {

    private Variable var;

    private Expression exp;

    public VarDef(Variable var, Expression exp) {
        this.var = var;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return null;
    }
}
