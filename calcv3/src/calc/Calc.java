package calc;

import ast.AST;
import ast.Body;
import ast.Expression;
import eval.State;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import parser.*;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Calc {
    static boolean verbose = false;

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length == 0) verbose = true;
        if ( args.length>0 ) inputFile = args[0];
        if (args.length>1 && args[1].equals("-v")) verbose = true;
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        // System.out.println("==>" + interpret(is));
        compile(is, inputFile);
    }

    public static AST analyze(InputStream is) throws IOException {
        try {
            ANTLRInputStream input = new ANTLRInputStream(is);
            CalcLexer lexer = new ReportingCalcLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalcParser parser = new CalcParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener());

            ParseTree tree = parser.program(); // Syntax analysis
            if (ErrorFlag.getFlag())
                throw new SyntaxError("");
            else {
                if (verbose) System.out.println("ANTLR Syntax tree: " + tree.toStringTree(parser));
                ASTVisitor visitor = new ASTVisitor();
                AST ast = (AST) visitor.visit(tree); // AST generation
                if (verbose) System.out.println("Abstract Syntax tree: " + ast);
//                ast.check() // Semantic analysis
                return ast;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static int interpret(InputStream is) throws IOException {
        AST ast = analyze(is);
        return ((Body)ast).eval(new State<Integer>()); // green track
    }
    public static void compile(InputStream is, String inputFile) throws IOException {
        AST ast = analyze(is);
        String code = ((Body)ast).gen(); // TODO : update to generate main and possibly blue and red tracks
        if (inputFile != null)
            write(code, inputFile);
        else
            System.out.println(code);
    }
    // write code to .c file associated to .calc file passed as argument,
    // returning .c file relative filename
    static String write(String code, String filename) throws IOException {
        String CFilename = filename.replaceFirst("\\.calc\\z", ".c");
        if (verbose && filename != null) System.out.println("writing C code to " + CFilename);
        FileWriter out = new FileWriter(CFilename);
        out.write(code);
        out.flush();
        out.close();
        return CFilename;
    }
}