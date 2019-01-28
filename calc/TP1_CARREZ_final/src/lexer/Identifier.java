package lexer;

public class Identifier implements Token {

    public String s;

    public Identifier(String s) {

        this.s = s;

    }

    @Override
    public String toString() {
        return "IDENTIFIER(" + s + ")";
    }
}
