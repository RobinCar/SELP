package parser;

import eval.State;
import lexer.*;

import java.io.IOException;

public abstract class Expression extends AST {

    public abstract int eval(State<Integer> s) throws IOException;

    public static Expression parse(Token t2) throws IOException, UnexpectedCharacter {
        if(t2 instanceof lexer.Op) {
            Token t3 = SLexer.getToken();
            Expression exp1 = Expression.parseSimpleExpression(t3);
            Token t4 = SLexer.getToken();

            if(t4 instanceof lexer.RPar) {
                if(t2 == Op.MINUS)
                    return new UnaryMinus(exp1);
                else
                    throw new SyntaxError("Error syntax unary");
            }
            else {
                Expression exp2 = Expression.parseSimpleExpression(t4);
                if (SLexer.getToken() instanceof lexer.RPar) {
                    return new BinaryExpression((lexer.Op) t2, exp1, exp2);
                } else {
                    throw new SyntaxError("Error syntax RPar");
                }
            }
        }
        else if(t2 instanceof lexer.If) {
            Expression exp1 = Expression.parseSimpleExpression(SLexer.getToken());
            Expression exp2 = Expression.parseSimpleExpression(SLexer.getToken());
            Expression exp3 = Expression.parseSimpleExpression(SLexer.getToken());
            if(SLexer.getToken() instanceof lexer.RPar) {
                return new ConditionalExpression(exp1 , exp2, exp3);
            } else {
                throw new SyntaxError("Error syntax");
            }
        }
        else {
            throw new SyntaxError("Error syntax");
        }
    }

    public static Expression parseSimpleExpression(Token t) throws IOException, UnexpectedCharacter {
        if(t instanceof lexer.Identifier) {
            return new Variable((Identifier) t);
        }
        else if(t instanceof lexer.Literal) {
            return new Literal(((lexer.Literal) t).value);
        }
        else if(t instanceof LPar) {
            return parse(SLexer.getToken());
        }
        else {
            throw new SyntaxError("Error syntax");
        }
    }
}
