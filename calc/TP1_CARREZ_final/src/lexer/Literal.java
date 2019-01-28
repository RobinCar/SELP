package lexer;

public class Literal implements Token {

    public int value;

    public Literal(int i) {

        this.value = i;
    }

    @Override
    public String toString() {
        return "LITERAL(" + value +")";
    }
}
