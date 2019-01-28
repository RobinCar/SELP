package parser;

import eval.State;
import lexer.Identifier;
import lexer.SLexer;
import lexer.Token;
import lexer.UnexpectedCharacter;

import java.io.IOException;
import java.util.ArrayList;

public class FuncDef extends AST {

    private Head head;

    private Body body;

    public FuncDef(Head head, Body body) {
        this.head = head;
        this.body = body;
    }

    public static FuncDef parse(Token t) throws IOException, UnexpectedCharacter {
        if(t instanceof lexer.LPar) {
            Token t2 = SLexer.getToken();
            if (t2 instanceof lexer.Identifier) {
                Function func = new Function((Identifier) t);

                Head head = new Head(new ArrayList<Variable>(), func);

                Token t3 = SLexer.getToken();

                while (t3 instanceof lexer.Identifier) {
                    Variable var = new Variable((Identifier) t3);
                    head.getVars().add(var);
                    t3 = SLexer.getToken();
                }

                Body body = Body.parseSimpleBody(t3, new ArrayList<VarDef>());
                if (SLexer.getToken() instanceof lexer.RPar) {
                    return new FuncDef(head, body);
                } else throw new SyntaxError("Pas de RPar");
            } else throw new SyntaxError("Error");
        } else throw new SyntaxError("Error");
    }

    @Override
    public String toString() {
        return "FuncDef( defun " + head + " = " + body + ")";
    }

    public void eval(State<Integer> s) throws IOException {
        if(s.containsKey(head.getFunc().getFunc().s)) throw new IOException("Fonction deja presente");
        s.bind(head.getFunc().getFunc().s, body.eval(s));
    }
}
