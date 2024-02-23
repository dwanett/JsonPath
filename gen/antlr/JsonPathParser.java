// Generated from C:/Users/NIKITA-PC/Desktop/jsonPath_v3/src/main/java/antlr/JsonPath.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JsonPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, STRING=8, FUNCTION=9, 
		FUNCTIONFORCOMPARE=10, INDEXARRAY=11, MATCHTYPE=12, FLOAT=13, COMPARETYPE=14, 
		COMPARETYPENOTSTRICT=15, LOGICEXPR=16, DIGIT=17, NAME=18, NO_NAME=19, 
		ALLINDEX=20, NOT=21, DOT=22, BACK=23, NONMATCH=24, ALLMATCH=25, AND=26, 
		OR=27, EQUALS=28, NOT_EQUALS=29, LESS=30, LESS_OR_EQUALS=31, GREATER=32, 
		GREATER_OR_EQUALS=33, SORT=34, SIZE=35, DISTINCT=36, NAMEATTR=37, REG=38, 
		CONTAINS=39, WS=40;
	public static final int
		RULE_jsonPath = 0, RULE_jsonPathElement = 1, RULE_filter = 2, RULE_condition = 3, 
		RULE_priority = 4, RULE_expr = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"jsonPath", "jsonPathElement", "filter", "condition", "priority", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "'('", "')]'", "'{'", "'}'", "'null'", "'empty'", null, 
			null, null, null, null, null, null, null, null, null, null, "'*'", "'~'", 
			"'!'", "'.'", "'../'", "'nonMatch'", "'allMatch'", "'&&'", "'||'", "'=='", 
			"'!='", "'<'", "'<='", "'>'", "'>='", "'sort()'", "'size()'", "'distinct()'", 
			"'name()'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "STRING", "FUNCTION", 
			"FUNCTIONFORCOMPARE", "INDEXARRAY", "MATCHTYPE", "FLOAT", "COMPARETYPE", 
			"COMPARETYPENOTSTRICT", "LOGICEXPR", "DIGIT", "NAME", "NO_NAME", "ALLINDEX", 
			"NOT", "DOT", "BACK", "NONMATCH", "ALLMATCH", "AND", "OR", "EQUALS", 
			"NOT_EQUALS", "LESS", "LESS_OR_EQUALS", "GREATER", "GREATER_OR_EQUALS", 
			"SORT", "SIZE", "DISTINCT", "NAMEATTR", "REG", "CONTAINS", "WS"
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

	@Override
	public String getGrammarFileName() { return "JsonPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JsonPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JsonPathContext extends ParserRuleContext {
		public JsonPathElementContext jsonPathElement() {
			return getRuleContext(JsonPathElementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JsonPathParser.EOF, 0); }
		public JsonPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).enterJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).exitJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonPathVisitor ) return ((JsonPathVisitor<? extends T>)visitor).visitJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonPathContext jsonPath() throws RecognitionException {
		JsonPathContext _localctx = new JsonPathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_jsonPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			jsonPathElement();
			setState(13);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JsonPathElementContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(JsonPathParser.NAME, 0); }
		public TerminalNode STRING() { return getToken(JsonPathParser.STRING, 0); }
		public TerminalNode NO_NAME() { return getToken(JsonPathParser.NO_NAME, 0); }
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public TerminalNode INDEXARRAY() { return getToken(JsonPathParser.INDEXARRAY, 0); }
		public TerminalNode DOT() { return getToken(JsonPathParser.DOT, 0); }
		public JsonPathElementContext jsonPathElement() {
			return getRuleContext(JsonPathElementContext.class,0);
		}
		public TerminalNode FUNCTION() { return getToken(JsonPathParser.FUNCTION, 0); }
		public JsonPathElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonPathElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).enterJsonPathElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).exitJsonPathElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonPathVisitor ) return ((JsonPathVisitor<? extends T>)visitor).visitJsonPathElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonPathElementContext jsonPathElement() throws RecognitionException {
		JsonPathElementContext _localctx = new JsonPathElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_jsonPathElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 786688L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(16);
				filter();
				}
			}

			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INDEXARRAY) {
				{
				setState(19);
				match(INDEXARRAY);
				}
			}

			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(22);
				match(DOT);
				setState(25);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case NAME:
				case NO_NAME:
					{
					setState(23);
					jsonPathElement();
					}
					break;
				case FUNCTION:
					{
					setState(24);
					match(FUNCTION);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FilterContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode MATCHTYPE() { return getToken(JsonPathParser.MATCHTYPE, 0); }
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).exitFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonPathVisitor ) return ((JsonPathVisitor<? extends T>)visitor).visitFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(T__0);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MATCHTYPE) {
				{
				setState(30);
				match(MATCHTYPE);
				}
			}

			setState(33);
			match(T__1);
			setState(34);
			condition();
			setState(35);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> LOGICEXPR() { return getTokens(JsonPathParser.LOGICEXPR); }
		public TerminalNode LOGICEXPR(int i) {
			return getToken(JsonPathParser.LOGICEXPR, i);
		}
		public List<PriorityContext> priority() {
			return getRuleContexts(PriorityContext.class);
		}
		public PriorityContext priority(int i) {
			return getRuleContext(PriorityContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonPathVisitor ) return ((JsonPathVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_condition);
		int _la;
		try {
			int _alt;
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				expr();
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOGICEXPR) {
					{
					{
					setState(38);
					match(LOGICEXPR);
					setState(39);
					expr();
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(47);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case STRING:
						case FUNCTIONFORCOMPARE:
						case NAME:
						case NO_NAME:
						case NOT:
							{
							setState(45);
							expr();
							}
							break;
						case T__3:
							{
							setState(46);
							priority();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(49);
						match(LOGICEXPR);
						}
						} 
					}
					setState(55);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(56);
				priority();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOGICEXPR) {
					{
					{
					setState(57);
					match(LOGICEXPR);
					setState(60);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STRING:
					case FUNCTIONFORCOMPARE:
					case NAME:
					case NO_NAME:
					case NOT:
						{
						setState(58);
						expr();
						}
						break;
					case T__3:
						{
						setState(59);
						priority();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PriorityContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public PriorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_priority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).enterPriority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).exitPriority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonPathVisitor ) return ((JsonPathVisitor<? extends T>)visitor).visitPriority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PriorityContext priority() throws RecognitionException {
		PriorityContext _localctx = new PriorityContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_priority);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__3);
			setState(70);
			condition();
			setState(71);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<JsonPathElementContext> jsonPathElement() {
			return getRuleContexts(JsonPathElementContext.class);
		}
		public JsonPathElementContext jsonPathElement(int i) {
			return getRuleContext(JsonPathElementContext.class,i);
		}
		public TerminalNode COMPARETYPE() { return getToken(JsonPathParser.COMPARETYPE, 0); }
		public TerminalNode COMPARETYPENOTSTRICT() { return getToken(JsonPathParser.COMPARETYPENOTSTRICT, 0); }
		public TerminalNode DIGIT() { return getToken(JsonPathParser.DIGIT, 0); }
		public TerminalNode FLOAT() { return getToken(JsonPathParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(JsonPathParser.STRING, 0); }
		public TerminalNode FUNCTIONFORCOMPARE() { return getToken(JsonPathParser.FUNCTIONFORCOMPARE, 0); }
		public List<TerminalNode> BACK() { return getTokens(JsonPathParser.BACK); }
		public TerminalNode BACK(int i) {
			return getToken(JsonPathParser.BACK, i);
		}
		public TerminalNode NOT() { return getToken(JsonPathParser.NOT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JsonPathListener ) ((JsonPathListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonPathVisitor ) return ((JsonPathVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				jsonPathElement();
				setState(74);
				match(COMPARETYPE);
				setState(75);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				jsonPathElement();
				setState(78);
				match(COMPARETYPE);
				setState(79);
				match(T__6);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				jsonPathElement();
				setState(82);
				_la = _input.LA(1);
				if ( !(_la==COMPARETYPE || _la==COMPARETYPENOTSTRICT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(83);
				_la = _input.LA(1);
				if ( !(_la==FLOAT || _la==DIGIT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				jsonPathElement();
				setState(86);
				match(COMPARETYPE);
				setState(87);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(89);
				jsonPathElement();
				setState(90);
				match(COMPARETYPE);
				setState(91);
				match(FUNCTIONFORCOMPARE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				jsonPathElement();
				setState(94);
				match(COMPARETYPE);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					match(BACK);
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==BACK );
				setState(100);
				jsonPathElement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(102);
					match(NOT);
					}
				}

				setState(105);
				match(FUNCTIONFORCOMPARE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(106);
					match(NOT);
					}
				}

				setState(109);
				jsonPathElement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001(q\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0012\b\u0001\u0001\u0001\u0003\u0001\u0015\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001a\b\u0001\u0003\u0001\u001c"+
		"\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002 \b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003)\b\u0003\n\u0003\f\u0003,\t\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u00030\b\u0003\u0001\u0003\u0001\u0003\u0005\u00034\b\u0003\n\u0003\f"+
		"\u00037\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003=\b\u0003\u0005\u0003?\b\u0003\n\u0003\f\u0003B\t\u0003\u0003\u0003"+
		"D\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005a\b\u0005"+
		"\u000b\u0005\f\u0005b\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"h\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005l\b\u0005\u0001\u0005\u0003"+
		"\u0005o\b\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006"+
		"\b\n\u0000\u0003\u0002\u0000\b\b\u0012\u0013\u0001\u0000\u000e\u000f\u0002"+
		"\u0000\r\r\u0011\u0011\u007f\u0000\f\u0001\u0000\u0000\u0000\u0002\u000f"+
		"\u0001\u0000\u0000\u0000\u0004\u001d\u0001\u0000\u0000\u0000\u0006C\u0001"+
		"\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000\nn\u0001\u0000\u0000\u0000"+
		"\f\r\u0003\u0002\u0001\u0000\r\u000e\u0005\u0000\u0000\u0001\u000e\u0001"+
		"\u0001\u0000\u0000\u0000\u000f\u0011\u0007\u0000\u0000\u0000\u0010\u0012"+
		"\u0003\u0004\u0002\u0000\u0011\u0010\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0001\u0000\u0000\u0000\u0012\u0014\u0001\u0000\u0000\u0000\u0013\u0015"+
		"\u0005\u000b\u0000\u0000\u0014\u0013\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0001\u0000\u0000\u0000\u0015\u001b\u0001\u0000\u0000\u0000\u0016\u0019"+
		"\u0005\u0016\u0000\u0000\u0017\u001a\u0003\u0002\u0001\u0000\u0018\u001a"+
		"\u0005\t\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u0018\u0001"+
		"\u0000\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0016\u0001"+
		"\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0003\u0001"+
		"\u0000\u0000\u0000\u001d\u001f\u0005\u0001\u0000\u0000\u001e \u0005\f"+
		"\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000"+
		"\u0000 !\u0001\u0000\u0000\u0000!\"\u0005\u0002\u0000\u0000\"#\u0003\u0006"+
		"\u0003\u0000#$\u0005\u0003\u0000\u0000$\u0005\u0001\u0000\u0000\u0000"+
		"%*\u0003\n\u0005\u0000&\'\u0005\u0010\u0000\u0000\')\u0003\n\u0005\u0000"+
		"(&\u0001\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000*+\u0001\u0000\u0000\u0000+D\u0001\u0000\u0000\u0000,*\u0001\u0000"+
		"\u0000\u0000-0\u0003\n\u0005\u0000.0\u0003\b\u0004\u0000/-\u0001\u0000"+
		"\u0000\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0005"+
		"\u0010\u0000\u000024\u0001\u0000\u0000\u00003/\u0001\u0000\u0000\u0000"+
		"47\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000068\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u00008@\u0003\b\u0004"+
		"\u00009<\u0005\u0010\u0000\u0000:=\u0003\n\u0005\u0000;=\u0003\b\u0004"+
		"\u0000<:\u0001\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=?\u0001\u0000"+
		"\u0000\u0000>9\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000C%\u0001\u0000\u0000\u0000C5\u0001\u0000\u0000"+
		"\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0005\u0004\u0000\u0000FG\u0003"+
		"\u0006\u0003\u0000GH\u0005\u0005\u0000\u0000H\t\u0001\u0000\u0000\u0000"+
		"IJ\u0003\u0002\u0001\u0000JK\u0005\u000e\u0000\u0000KL\u0005\u0006\u0000"+
		"\u0000Lo\u0001\u0000\u0000\u0000MN\u0003\u0002\u0001\u0000NO\u0005\u000e"+
		"\u0000\u0000OP\u0005\u0007\u0000\u0000Po\u0001\u0000\u0000\u0000QR\u0003"+
		"\u0002\u0001\u0000RS\u0007\u0001\u0000\u0000ST\u0007\u0002\u0000\u0000"+
		"To\u0001\u0000\u0000\u0000UV\u0003\u0002\u0001\u0000VW\u0005\u000e\u0000"+
		"\u0000WX\u0005\b\u0000\u0000Xo\u0001\u0000\u0000\u0000YZ\u0003\u0002\u0001"+
		"\u0000Z[\u0005\u000e\u0000\u0000[\\\u0005\n\u0000\u0000\\o\u0001\u0000"+
		"\u0000\u0000]^\u0003\u0002\u0001\u0000^`\u0005\u000e\u0000\u0000_a\u0005"+
		"\u0017\u0000\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000de\u0003\u0002\u0001\u0000eo\u0001\u0000\u0000\u0000fh\u0005\u0015"+
		"\u0000\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000io\u0005\n\u0000\u0000jl\u0005\u0015\u0000\u0000kj\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"mo\u0003\u0002\u0001\u0000nI\u0001\u0000\u0000\u0000nM\u0001\u0000\u0000"+
		"\u0000nQ\u0001\u0000\u0000\u0000nU\u0001\u0000\u0000\u0000nY\u0001\u0000"+
		"\u0000\u0000n]\u0001\u0000\u0000\u0000ng\u0001\u0000\u0000\u0000nk\u0001"+
		"\u0000\u0000\u0000o\u000b\u0001\u0000\u0000\u0000\u000f\u0011\u0014\u0019"+
		"\u001b\u001f*/5<@Cbgkn";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}