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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, BOOLEAN=7, MULTIPLICATIVE=8, 
		ADDITIVE=9, RELATIONAL=10, EQUALITY=11, AND=12, OR=13, MINUS=14, NOT=15, 
		OP=16, IDENTIFIER=17, LITERAL=18, WS=19, LINE_COMMENT=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "BOOLEAN", "MULTIPLICATIVE", 
			"ADDITIVE", "RELATIONAL", "EQUALITY", "AND", "OR", "MINUS", "NOT", "OP", 
			"IDENTIFIER", "LITERAL", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'defun'", "')'", "'='", "'?'", "':'", null, null, null, 
			null, null, "'&&'", "'||'", "'-'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "BOOLEAN", "MULTIPLICATIVE", 
			"ADDITIVE", "RELATIONAL", "EQUALITY", "AND", "OR", "MINUS", "NOT", "OP", 
			"IDENTIFIER", "LITERAL", "WS", "LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"E\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13P\n\13\3\f\3\f\3\f"+
		"\3\f\5\fV\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21p\n\21"+
		"\3\22\3\22\7\22t\n\22\f\22\16\22w\13\22\3\23\3\23\3\23\7\23|\n\23\f\23"+
		"\16\23\177\13\23\5\23\u0081\n\23\3\24\6\24\u0084\n\24\r\24\16\24\u0085"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u008e\n\25\f\25\16\25\u0091\13\25"+
		"\3\25\3\25\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\t\4\2,,\61\61"+
		"\4\2--//\4\2>>@@\4\2,-\61\61\4\2\62;c|\5\2\13\f\17\17\"\"\3\2\f\f\2\u00a5"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7\63\3\2"+
		"\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17D\3\2\2\2\21F\3\2\2\2\23"+
		"H\3\2\2\2\25O\3\2\2\2\27U\3\2\2\2\31W\3\2\2\2\33Z\3\2\2\2\35]\3\2\2\2"+
		"\37_\3\2\2\2!o\3\2\2\2#q\3\2\2\2%\u0080\3\2\2\2\'\u0083\3\2\2\2)\u0089"+
		"\3\2\2\2+,\7*\2\2,\4\3\2\2\2-.\7f\2\2./\7g\2\2/\60\7h\2\2\60\61\7w\2\2"+
		"\61\62\7p\2\2\62\6\3\2\2\2\63\64\7+\2\2\64\b\3\2\2\2\65\66\7?\2\2\66\n"+
		"\3\2\2\2\678\7A\2\28\f\3\2\2\29:\7<\2\2:\16\3\2\2\2;<\7v\2\2<=\7t\2\2"+
		"=>\7w\2\2>E\7g\2\2?@\7h\2\2@A\7c\2\2AB\7n\2\2BC\7u\2\2CE\7g\2\2D;\3\2"+
		"\2\2D?\3\2\2\2E\20\3\2\2\2FG\t\2\2\2G\22\3\2\2\2HI\t\3\2\2I\24\3\2\2\2"+
		"JP\t\4\2\2KL\7>\2\2LP\7?\2\2MN\7@\2\2NP\7?\2\2OJ\3\2\2\2OK\3\2\2\2OM\3"+
		"\2\2\2P\26\3\2\2\2QR\7?\2\2RV\7?\2\2ST\7#\2\2TV\7?\2\2UQ\3\2\2\2US\3\2"+
		"\2\2V\30\3\2\2\2WX\7(\2\2XY\7(\2\2Y\32\3\2\2\2Z[\7~\2\2[\\\7~\2\2\\\34"+
		"\3\2\2\2]^\7/\2\2^\36\3\2\2\2_`\7#\2\2` \3\2\2\2ap\t\5\2\2bc\7?\2\2cp"+
		"\7?\2\2dp\t\4\2\2ef\7>\2\2fp\7?\2\2gh\7@\2\2hp\7?\2\2ij\7#\2\2jp\7?\2"+
		"\2kl\7(\2\2lp\7(\2\2mn\7~\2\2np\7~\2\2oa\3\2\2\2ob\3\2\2\2od\3\2\2\2o"+
		"e\3\2\2\2og\3\2\2\2oi\3\2\2\2ok\3\2\2\2om\3\2\2\2p\"\3\2\2\2qu\4c|\2r"+
		"t\t\6\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v$\3\2\2\2wu\3\2\2\2"+
		"x\u0081\7\62\2\2y}\4\63;\2z|\4\62;\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2"+
		"}~\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\u0080x\3\2\2\2\u0080y\3\2\2\2\u0081"+
		"&\3\2\2\2\u0082\u0084\t\7\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088"+
		"\b\24\2\2\u0088(\3\2\2\2\u0089\u008a\7\61\2\2\u008a\u008b\7\61\2\2\u008b"+
		"\u008f\3\2\2\2\u008c\u008e\n\b\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0093\7\f\2\2\u0093\u0094\3\2\2\2\u0094\u0095\b\25"+
		"\2\2\u0095*\3\2\2\2\f\2DOUou}\u0080\u0085\u008f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}