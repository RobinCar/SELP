package parser;

import eval.State;
import lexer.DefVar;
import lexer.SLexer;
import lexer.Token;
import lexer.UnexpectedCharacter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program extends AST {

    private List<FuncDef> defs;

    private Body body;

    public Program(List<FuncDef> defs, Body body) {
        this.defs = defs;
        this.body = body;
    }

    public static Program parse(Token token, List<FuncDef> defs) throws IOException, UnexpectedCharacter {
        if (token instanceof lexer.LPar) {
            Token token2 = SLexer.getToken();
            if (token2 instanceof lexer.Defun) { // this is a definition
                // parse tail of definition
                FuncDef def = FuncDef.parse(SLexer.getToken());
                // accumulate definition
                defs.add(def);
                // loop on the rest of the body with the accumulated definitions
                return parse(SLexer.getToken(), defs);
            } else { // this is the "composite" expression at the end of the body
                Body body = Body.parse(token2, new ArrayList<VarDef>());
                return new Program(defs, body);
            }
        } else // this is the "simple" expression at the end of the body
            return parseSimpleProgram(token, defs);
    }
    static Program parseSimpleProgram(Token token, List<FuncDef> defs) throws IOException, UnexpectedCharacter {
        Body body =  Body.parseSimpleBody(token, new ArrayList<VarDef>());
        return new Program(defs, body);
    }

    @Override
    public String toString()  {
        return "Program(" + defs + " " + body + ")";
    }

    public int eval(State<Integer> s) throws IOException {
        for (FuncDef f:defs){
            f.eval(s);
        }
        return this.body.eval(s);
    }
}
