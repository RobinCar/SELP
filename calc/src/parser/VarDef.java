package parser;

import eval.State;
import lexer.Identifier;
import lexer.SLexer;
import lexer.Token;
import lexer.UnexpectedCharacter;

import java.io.IOException;

public class VarDef extends AST {

    private Variable var;

    private Expression exp;

    public VarDef(Variable var, Expression exp) {
        this.var = var;
        this.exp = exp;
    }

    public static VarDef parse(Token t) throws IOException, UnexpectedCharacter {
        if(t instanceof lexer.Identifier) {
            Expression exp = Expression.parseSimpleExpression(SLexer.getToken());
            if(SLexer.getToken() instanceof lexer.RPar) {
                return new VarDef(new Variable((Identifier) t), exp);
            }
            else throw new SyntaxError("Pas de RPar");
        }
        else throw new SyntaxError("Error");
    }

    @Override
    public String toString() {
        return "VarDef(" + var + " = " + exp + ")";
    }

    public void eval(State<Integer> s) throws IOException {
        if(s.containsKey(var.getVar())) throw new IOException("Variable deja presente");
        s.bind(var.getVar(), exp.eval(s));
    }
}
