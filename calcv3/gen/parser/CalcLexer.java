// Generated from /home/robin/Documents/FILA1/StructureEtExecutionDesLangagesDeProgrammation/calcv3/src/parser/Calc.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, OP2=8, OP=9, IDENTIFIER=10, 
		LITERAL=11, WS=12, LINE_COMMENT=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "OP2", "OP", 
			"IDENTIFIER", "LITERAL", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'defun'", "')'", "'='", "'-'", "'?'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "OP2", "OP", "IDENTIFIER", 
			"LITERAL", "WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17\\\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\5\n\66\n\n"+
		"\3\13\3\13\7\13:\n\13\f\13\16\13=\13\13\3\f\3\f\3\f\7\fB\n\f\f\f\16\f"+
		"E\13\f\5\fG\n\f\3\r\6\rJ\n\r\r\r\16\rK\3\r\3\r\3\16\3\16\3\16\3\16\7\16"+
		"T\n\16\f\16\16\16W\13\16\3\16\3\16\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\7\4\2--//\5\2,-//\61"+
		"\61\4\2\62;c|\5\2\13\f\17\17\"\"\3\2\f\f\2b\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\3\35\3\2\2\2\5\37\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13)\3\2\2\2\r+\3\2\2"+
		"\2\17-\3\2\2\2\21/\3\2\2\2\23\65\3\2\2\2\25\67\3\2\2\2\27F\3\2\2\2\31"+
		"I\3\2\2\2\33O\3\2\2\2\35\36\7*\2\2\36\4\3\2\2\2\37 \7f\2\2 !\7g\2\2!\""+
		"\7h\2\2\"#\7w\2\2#$\7p\2\2$\6\3\2\2\2%&\7+\2\2&\b\3\2\2\2\'(\7?\2\2(\n"+
		"\3\2\2\2)*\7/\2\2*\f\3\2\2\2+,\7A\2\2,\16\3\2\2\2-.\7<\2\2.\20\3\2\2\2"+
		"/\60\t\2\2\2\60\22\3\2\2\2\61\66\t\3\2\2\62\63\7?\2\2\63\66\7?\2\2\64"+
		"\66\7>\2\2\65\61\3\2\2\2\65\62\3\2\2\2\65\64\3\2\2\2\66\24\3\2\2\2\67"+
		";\4c|\28:\t\4\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\26\3\2\2\2"+
		"=;\3\2\2\2>G\7\62\2\2?C\4\63;\2@B\4\62;\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2"+
		"\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2\2F>\3\2\2\2F?\3\2\2\2G\30\3\2\2\2HJ\t\5"+
		"\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\b\r\2\2N\32\3"+
		"\2\2\2OP\7\61\2\2PQ\7\61\2\2QU\3\2\2\2RT\n\6\2\2SR\3\2\2\2TW\3\2\2\2U"+
		"S\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\f\2\2YZ\3\2\2\2Z[\b\16\2\2"+
		"[\34\3\2\2\2\t\2\65;CFKU\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}