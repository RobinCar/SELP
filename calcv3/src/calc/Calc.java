package calc;

import ast.AST;
import ast.Body;
import ast.Expression;
import eval.State;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parser.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Calc {
    // static boolean verbose = false;

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        // if (args.length>1 && args[1].equals("-v")) verbose = true;
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        System.out.println("===> " + interpret(is));

    }

    public static int interpret(InputStream is) throws IOException {
        try {

            State s = new State();
            ANTLRInputStream input = new ANTLRInputStream(is);
            ReportingCalcLexer lexer = new ReportingCalcLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalcParser parser = new CalcParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener());

            ParseTree tree = parser.program();

            System.out.println(tree.toStringTree(parser));
            ASTVisitor visitor = new ASTVisitor();
            AST ast = visitor.visit(tree);
            System.out.println(ast);
            Body exp = (Body) ast;
            return exp.eval(s);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
