package parser;

public class Variable extends Expression {

    private String var;

    public Variable(String var) {
        this.var = var;
    }

    @Override
    public int eval() {
        return 0;
    }

    @Override
    public String toString() {
        return "Variable(" + var + ")";
    }
}
