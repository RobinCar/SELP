package parser;

public class UnaryMinus extends Expression{

    Expression exp;

    public UnaryMinus(Expression exp) {
        this.exp = exp;
    }

    public String toString() {
        return "UnaryMinus(" + "-" + exp + ")";
    }

    @Override
    public int eval() {
        return - exp.eval();
    }
}
