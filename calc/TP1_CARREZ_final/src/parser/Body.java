package parser;

import eval.State;
import lexer.SLexer;
import lexer.Token;
import lexer.UnexpectedCharacter;

import java.io.IOException;
import java.util.List;

public class Body extends AST {

    private List<VarDef> defs;

    private Expression exp;

    public Body(List<VarDef> defs, Expression exp) {
        this.defs = defs;
        this.exp = exp;
    }

    public static Body parse(Token token, List<VarDef> defs) throws IOException, UnexpectedCharacter {
        if (token instanceof lexer.LPar) {
            Token token2 = SLexer.getToken();
            if (token2 instanceof lexer.DefVar) { // this is a definition
                // parse tail of definition
                VarDef def = VarDef.parse(SLexer.getToken());
                // accumulate definition
                defs.add(def);
                // loop on the rest of the body with the accumulated definitions
                return parse(SLexer.getToken(), defs);
            } else { // this is the "composite" expression at the end of the body
                Expression exp = Expression.parse(token2);
                return new Body(defs, exp);
            }
        } else // this is the "simple" expression at the end of the body
            return parseSimpleBody(token, defs);
    }
    static Body parseSimpleBody(Token token, List<VarDef> defs) throws IOException, UnexpectedCharacter {
        Expression exp =  Expression.parseSimpleExpression(token);
        return new Body(defs, exp);
    }

    @Override
    public String toString() {
        return "Body(" + defs + " " + exp + ")";
    }

    public int eval(State<Integer> s) throws IOException {
        for (VarDef f:defs){
            f.eval(s);
        }
        return this.exp.eval(s);
    }
}
