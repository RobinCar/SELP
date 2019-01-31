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
    public AST visitUnaryExpression(CalcParser.UnaryExpressionContext ctx) {
        Expression exp1 = (Expression) visit(ctx.expression());
        if(ctx.MINUS() != null)
            return new UnaryExpression(exp1, Op.MINUS);
        else if(ctx.NOT() != null)
            return new UnaryExpression(exp1, Op.NOT);
        else throw new SyntaxError("Error");
    }

    @Override
    public AST visitBinaryExpression(CalcParser.BinaryExpressionContext ctx) {
        Op op = null;

        if(ctx.MULTIPLICATIVE() != null) {
            try {
                op = Op.parseOp(ctx.MULTIPLICATIVE().getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(ctx.ADDITIVE() != null){
            try {
                op = Op.parseOp(ctx.ADDITIVE().getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(ctx.RELATIONAL() != null){
            try {
                op = Op.parseOp(ctx.RELATIONAL().getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(ctx.EQUALITY() != null){
            try {
                op = Op.parseOp(ctx.EQUALITY().getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(ctx.AND() != null){
            try {
                op = Op.parseOp(ctx.AND().getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(ctx.OR() != null){
            try {
                op = Op.parseOp(ctx.OR().getText());
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
    public AST visitBooleanLiteral(CalcParser.BooleanLiteralContext ctx) {
        String bool = ctx.BOOLEAN().getText();
        if(bool.equals("true")) return new BooleanLiteral(true);
        else return new BooleanLiteral(false);
    }

    @Override
    public AST visitParenExpression(CalcParser.ParenExpressionContext ctx) {
        CalcParser.ExpressionContext exp = ctx.expression();

        if(exp instanceof CalcParser.LiteralContext) return this.visitLiteral((CalcParser.LiteralContext)exp);
        else if(exp instanceof CalcParser.VariableContext) return this.visitVariable((CalcParser.VariableContext)exp);
        else if(exp instanceof CalcParser.UnaryExpressionContext) return this.visitUnaryExpression((CalcParser.UnaryExpressionContext)exp);
        else if(exp instanceof CalcParser.ConditionalExpressionContext) return this.visitConditionalExpression((CalcParser.ConditionalExpressionContext)exp);
        else if(exp instanceof CalcParser.BinaryExpressionContext) return this.visitBinaryExpression((CalcParser.BinaryExpressionContext)exp);
        else throw new SyntaxError("Error parenthèse");

    }

}
