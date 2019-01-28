package parser;

import ast.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends CalcBaseVisitor<AST> {

    @Override
    public AST visitLiteral(CalcParser.LiteralContext ctx) {
        return new Literal(Integer.parseInt(ctx.getText()));
    }

    @Override
    public AST visitVariable(CalcParser.VariableContext ctx) { return new Variable(ctx.getText()); }

    @Override
    public AST visitBody(CalcParser.BodyContext ctx) {
        // retrieve ASTs for definitions
        List<CalcParser.VarDefContext> varDefCtxs = ctx.varDef();
        List<VarDef> varDefs = new ArrayList<>();
        for (CalcParser.VarDefContext varDefCtx : varDefCtxs)
            varDefs.add((VarDef)visit(varDefCtx));
        // retrieve AST for expression
        Expression expr = (Expression)visit(ctx.expression());
        // return AST for program
        return new Body(varDefs, expr);
    }

    @Override
    public AST visitUnaryMinus(CalcParser.UnaryMinusContext ctx) {
        Expression exp1 = (Expression) visit(ctx.expression());
        return new UnaryMinus(exp1);
    }

    @Override
    public AST visitBinaryExpression(CalcParser.BinaryExpressionContext ctx) {
        Op op = null;

        if(ctx.OP() != null) {
            try {
                op = Op.parseOp(ctx.OP().getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                op = Op.parseOp(ctx.MINUS().getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<CalcParser.ExpressionContext> expressionCtx = ctx.expression();
        Expression exp1 = (Expression) visit(expressionCtx.get(0));
        Expression exp2 = (Expression) visit(expressionCtx.get(1));
        return new BinaryExpression(op, exp1, exp2);
    }

    @Override
    public AST visitConditionalExpression(CalcParser.ConditionalExpressionContext ctx) {
        List<CalcParser.ExpressionContext> expressionCtx = ctx.expression();
        Expression exp1 = (Expression) visit(expressionCtx.get(0));
        Expression exp2 = (Expression) visit(expressionCtx.get(1));
        Expression exp3 = (Expression) visit(expressionCtx.get(2));
        return new ConditionalExpression(exp1, exp2, exp3);
    }

    @Override
    public AST visitParenExpression(CalcParser.ParenExpressionContext ctx) {
        CalcParser.ExpressionContext exp = ctx.expression();

        if(exp instanceof CalcParser.LiteralContext) return this.visitLiteral((CalcParser.LiteralContext)exp);
        else if(exp instanceof CalcParser.VariableContext) return this.visitVariable((CalcParser.VariableContext)exp);
        else if(exp instanceof CalcParser.UnaryMinusContext) return this.visitUnaryMinus((CalcParser.UnaryMinusContext)exp);
        else if(exp instanceof CalcParser.ConditionalExpressionContext) return this.visitConditionalExpression((CalcParser.ConditionalExpressionContext)exp);
        else if(exp instanceof CalcParser.BinaryExpressionContext) return this.visitBinaryExpression((CalcParser.BinaryExpressionContext)exp);
        else throw new SyntaxError("Error parenthèse");

    }

}
