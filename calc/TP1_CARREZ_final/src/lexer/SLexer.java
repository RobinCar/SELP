package lexer;

import java.io.IOException;
import java.io.InputStream;

public class SLexer {
    static private Lexer lexer;
    static public void init(InputStream is) throws IOException {
        lexer = new Lexer(is);
    }
    static public Token getToken() throws IOException, UnexpectedCharacter {
        return lexer.getToken();
    }
}
