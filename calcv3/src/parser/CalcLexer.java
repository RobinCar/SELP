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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, BOOLEAN=7, MINUS=8, NOT=9, 
		OP=10, IDENTIFIER=11, LITERAL=12, WS=13, LINE_COMMENT=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "BOOLEAN", "MINUS", "NOT", 
			"OP", "IDENTIFIER", "LITERAL", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'defun'", "')'", "'='", "'?'", "':'", null, "'-'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "BOOLEAN", "MINUS", "NOT", 
			"OP", "IDENTIFIER", "LITERAL", "WS", "LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20s\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b9\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13M\n\13\3\f\3\f\7\fQ\n\f\f\f\16\fT\13\f\3"+
		"\r\3\r\3\r\7\rY\n\r\f\r\16\r\\\13\r\5\r^\n\r\3\16\6\16a\n\16\r\16\16\16"+
		"b\3\16\3\16\3\17\3\17\3\17\3\17\7\17k\n\17\f\17\16\17n\13\17\3\17\3\17"+
		"\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\3\2\7\4\2,-\61\61\4\2>>@@\4\2\62;c|\5\2\13\f\17\17\"\""+
		"\3\2\f\f\2\177\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3"+
		"\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\178\3\2\2\2\21:\3"+
		"\2\2\2\23<\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31]\3\2\2\2\33`\3\2\2\2\35"+
		"f\3\2\2\2\37 \7*\2\2 \4\3\2\2\2!\"\7f\2\2\"#\7g\2\2#$\7h\2\2$%\7w\2\2"+
		"%&\7p\2\2&\6\3\2\2\2\'(\7+\2\2(\b\3\2\2\2)*\7?\2\2*\n\3\2\2\2+,\7A\2\2"+
		",\f\3\2\2\2-.\7<\2\2.\16\3\2\2\2/\60\7v\2\2\60\61\7t\2\2\61\62\7w\2\2"+
		"\629\7g\2\2\63\64\7h\2\2\64\65\7c\2\2\65\66\7n\2\2\66\67\7u\2\2\679\7"+
		"g\2\28/\3\2\2\28\63\3\2\2\29\20\3\2\2\2:;\7/\2\2;\22\3\2\2\2<=\7#\2\2"+
		"=\24\3\2\2\2>M\t\2\2\2?@\7?\2\2@M\7?\2\2AM\t\3\2\2BC\7>\2\2CM\7?\2\2D"+
		"E\7@\2\2EM\7?\2\2FG\7#\2\2GM\7?\2\2HI\7(\2\2IM\7(\2\2JK\7~\2\2KM\7~\2"+
		"\2L>\3\2\2\2L?\3\2\2\2LA\3\2\2\2LB\3\2\2\2LD\3\2\2\2LF\3\2\2\2LH\3\2\2"+
		"\2LJ\3\2\2\2M\26\3\2\2\2NR\4c|\2OQ\t\4\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2"+
		"\2RS\3\2\2\2S\30\3\2\2\2TR\3\2\2\2U^\7\62\2\2VZ\4\63;\2WY\4\62;\2XW\3"+
		"\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]U\3\2\2\2]"+
		"V\3\2\2\2^\32\3\2\2\2_a\t\5\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2"+
		"\2cd\3\2\2\2de\b\16\2\2e\34\3\2\2\2fg\7\61\2\2gh\7\61\2\2hl\3\2\2\2ik"+
		"\n\6\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2o"+
		"p\7\f\2\2pq\3\2\2\2qr\b\17\2\2r\36\3\2\2\2\n\28LRZ]bl\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}