package lexer;
import java.util.*;
import java.io.*;

import static lexer.Op.*;

public class Lexer {
	private InputStream in;
	private int i; // current ASCII character (coded as an integer)
	
	public Lexer(InputStream in) throws IOException {
		this.in = in;
		i = in.read(); // initialize current character
	}
	
	public List<Token> lex() throws UnexpectedCharacter, IOException {
		// return the list of tokens recorded in the file
		List<Token> tokens = new ArrayList<Token>();
		
		try {
			Token token = getToken();
	
			while (! (token instanceof EOF)) {
				tokens.add(token);
				token = getToken();
			}
			tokens.add(token); // this is the EOF token
		} catch (IOException e){
				in.close(); // close the reader
				throw e; // pass the exception up the stack
		}
		return tokens;
	}
	
	public Token getToken() throws UnexpectedCharacter, IOException {
		switch (i){
		    case -1 :
			    in.close();
			    return new EOF();
			case '\n' :
			case '\r' :
			case '\t' :
			case ' ' :
				i = in.read();
				return getToken();
			case '(' :
				i = in.read();
				return new LPar();
			case ')' :
				i = in.read();
				return new RPar();
			case '=' :
				i = in.read();

				if (i == '=') {
					i = in.read();
					return EQUAL;
				}
				else {
					return new DefVar();
				}
			case '+' :
				i = in.read();
				return PLUS;
			case '-' :
				i = in.read();
				return MINUS;
			case '*' :
				i = in.read();
				return TIMES;
			case '/' :
				i = in.read();
				return DIVIDE;
			case '<' :
				i = in.read();
				return LESS;
			case '0' :
				i = in.read();
				return new Literal(0);
			case 'i' :

				int valI = i;
				i = in.read();
				if (i == 'f') {
					i = in.read();
					if(i == ' ') {
						return new If();
					}
				}
				else {
					return new Identifier(Character.toString((char) valI));
				}

			case 'd' :

				int val = i;
				i = in.read();

				if (i == 'e') {

					val = i;
					i = in.read();

					if (i == 'f') {

						val = i;
						i = in.read();

						if (i == 'u') {

							val = i;
							i = in.read();

							if (i == 'n') {
								i = in.read();
								if(i == ' ') {
									return new Defun();
								}
							}
							else {
								return new Identifier(Character.toString((char) val));
							}

						}
						else {
							return new Identifier(Character.toString((char) val));
						}
					}
					else {
						return new Identifier(Character.toString((char) val));
					}
				}
				else {
					return new Identifier(Character.toString((char) val));
				}

			default :
				if ('1' <= i && i <= '9') {

					String s = Character.toString((char)i);
					i = in.read();

					while('0' <= i && i<= '9') {
						s = s + ((char) i);
						i = in.read();
					}

					return new Literal(Integer.parseInt(s));
				}
				else if ('a' <= i && i <= 'z') {

					String s = Character.toString((char)i);
					i = in.read();

					while(('a' <= i && i <= 'z') || ('1' <= i && i <= '9')) {
						s = s + ((char) i);
						i = in.read();
					}

					return new Identifier(s);
				}
				throw new UnexpectedCharacter(i);
		}
	}
}


