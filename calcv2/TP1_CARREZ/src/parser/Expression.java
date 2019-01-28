package parser;

import lexer.*;

import java.io.IOException;

public abstract class Expression extends AST {

    public abstract int eval();

    public static Expression parse(Token t) throws IOException, UnexpectedCharacter {

        if(t instanceof lexer.Literal) {
            return new Literal(((lexer.Literal) t).value);
        }

        if(t instanceof lexer.Identifier) {
            return new Variable(((lexer.Identifier) t).s);
        }

        else if(t instanceof lexer.LPar) {
            Token t2 = SLexer.getToken();
            if(t2 instanceof lexer.Op) {
                Token t3 = SLexer.getToken();
                Expression exp1 = Expression.parse(t3);
                Token t4 = SLexer.getToken();

                if(t4 instanceof lexer.RPar) {
                    if(t2 == Op.MINUS)
                        return new UnaryMinus(exp1);
                    else
                        throw new SyntaxError("Error syntax unary");
                }
                else {
                    Expression exp2 = Expression.parse(t4);
                    if (SLexer.getToken() instanceof lexer.RPar) {
                        return new BinaryExpression((lexer.Op) t2, exp1, exp2);
                    } else {
                        throw new SyntaxError("Error syntax RPar");
                    }
                }
            }
            else if(t2 instanceof lexer.If) {
                Expression exp1 = Expression.parse(SLexer.getToken());
                Expression exp2 = Expression.parse(SLexer.getToken());
                Expression exp3 = Expression.parse(SLexer.getToken());
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
        else {
            throw new SyntaxError("Unexpected first token in expression");
        }
    }
}
