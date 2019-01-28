package calc;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import eval.State;
import lexer.*;
import ast.Body;
import ast.VarDef;

public class CalcOld {
	/**
	 * @param args - arg[0] is the filename of the file to interpret
	 *     (if it exists, otherwise the standard input stream is used).
	 */
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		InputStream is = System.in;
		if (args.length > 0) {
			inputFile = args[0];
			is = new FileInputStream(inputFile);
		}
		System.out.println(interpret(is));
	}

	public static int interpret(InputStream is) throws IOException, UnexpectedCharacter {
		SLexer.init(is);
		State s = new State();
		Body body = Body.parse(SLexer.getToken(),new ArrayList<VarDef>());
		System.out.println(body);
		return body.eval(s);
	}
}
