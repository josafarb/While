// Generated from /home/jsantos/projects/ifrn20171/paradigmas/while/src/plp/enquanto/parser/Enquanto.g4 by ANTLR 4.7
package plp.enquanto.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnquantoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, INT=36, ID=37, Texto=38, Espaco=39;
	public static final int
		RULE_programa = 0, RULE_seqComando = 1, RULE_comando = 2, RULE_expressao = 3, 
		RULE_bool = 4;
	public static final String[] ruleNames = {
		"programa", "seqComando", "comando", "expressao", "bool"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':='", "'skip'", "'se'", "'entao'", "'senaose'", "'senao'", 
		"'enquanto'", "'faca'", "'para'", "'de'", "'ate'", "'passo'", "'escolha'", 
		"'caso'", "':'", "'outro'", "'exiba'", "'escreva'", "'{'", "'}'", "'leia'", 
		"'*'", "'+'", "'-'", "'/'", "'^'", "'('", "')'", "'verdadeiro'", "'falso'", 
		"'='", "'<='", "'nao'", "'e'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"INT", "ID", "Texto", "Espaco"
	};
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
	public String getGrammarFileName() { return "Enquanto.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EnquantoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public SeqComandoContext seqComando() {
			return getRuleContext(SeqComandoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			seqComando();
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

	public static class SeqComandoContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public SeqComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqComando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterSeqComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitSeqComando(this);
		}
	}

	public final SeqComandoContext seqComando() throws RecognitionException {
		SeqComandoContext _localctx = new SeqComandoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_seqComando);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			comando();
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(13);
				match(T__0);
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__7) | (1L << T__9) | (1L << T__13) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << ID))) != 0)) {
					{
					setState(14);
					comando();
					}
				}

				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ComandoContext extends ParserRuleContext {
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
	 
		public ComandoContext() { }
		public void copyFrom(ComandoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtribuicaoContext extends ComandoContext {
		public TerminalNode ID() { return getToken(EnquantoParser.ID, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtribuicaoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitAtribuicao(this);
		}
	}
	public static class SeContext extends ComandoContext {
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public SeContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterSe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitSe(this);
		}
	}
	public static class EscolhaContext extends ComandoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public EscolhaContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterEscolha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitEscolha(this);
		}
	}
	public static class ExibaContext extends ComandoContext {
		public TerminalNode Texto() { return getToken(EnquantoParser.Texto, 0); }
		public ExibaContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterExiba(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitExiba(this);
		}
	}
	public static class EnquantoContext extends ComandoContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public EnquantoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitEnquanto(this);
		}
	}
	public static class ParaContext extends ComandoContext {
		public TerminalNode ID() { return getToken(EnquantoParser.ID, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public ParaContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitPara(this);
		}
	}
	public static class BlocoContext extends ComandoContext {
		public SeqComandoContext seqComando() {
			return getRuleContext(SeqComandoContext.class,0);
		}
		public BlocoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitBloco(this);
		}
	}
	public static class EscrevaContext extends ComandoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public EscrevaContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterEscreva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitEscreva(this);
		}
	}
	public static class SkipContext extends ComandoContext {
		public SkipContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitSkip(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comando);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AtribuicaoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(ID);
				setState(23);
				match(T__1);
				setState(24);
				expressao(0);
				}
				break;
			case T__2:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(T__2);
				}
				break;
			case T__3:
				_localctx = new SeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				match(T__3);
				setState(27);
				bool(0);
				setState(28);
				match(T__4);
				setState(29);
				comando();
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(30);
					match(T__5);
					setState(31);
					bool(0);
					setState(32);
					match(T__4);
					setState(33);
					comando();
					}
				}

				setState(37);
				match(T__6);
				setState(38);
				comando();
				}
				break;
			case T__7:
				_localctx = new EnquantoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				match(T__7);
				setState(41);
				bool(0);
				setState(42);
				match(T__8);
				setState(43);
				comando();
				}
				break;
			case T__9:
				_localctx = new ParaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				match(T__9);
				setState(46);
				match(ID);
				setState(47);
				match(T__10);
				setState(48);
				expressao(0);
				setState(49);
				match(T__11);
				setState(50);
				expressao(0);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(51);
					match(T__12);
					setState(52);
					expressao(0);
					}
				}

				setState(55);
				match(T__8);
				setState(56);
				comando();
				}
				break;
			case T__13:
				_localctx = new EscolhaContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
				match(T__13);
				setState(59);
				expressao(0);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(60);
					match(T__14);
					setState(61);
					expressao(0);
					setState(62);
					match(T__15);
					setState(63);
					comando();
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(70);
				match(T__16);
				setState(71);
				match(T__15);
				setState(72);
				comando();
				}
				}
				break;
			case T__17:
				_localctx = new ExibaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(74);
				match(T__17);
				setState(75);
				match(Texto);
				}
				break;
			case T__18:
				_localctx = new EscrevaContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(76);
				match(T__18);
				setState(77);
				expressao(0);
				}
				break;
			case T__19:
				_localctx = new BlocoContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(78);
				match(T__19);
				setState(79);
				seqComando();
				setState(80);
				match(T__20);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressaoContext extends ParserRuleContext {
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	 
		public ExpressaoContext() { }
		public void copyFrom(ExpressaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LeiaContext extends ExpressaoContext {
		public LeiaContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterLeia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitLeia(this);
		}
	}
	public static class InteiroContext extends ExpressaoContext {
		public TerminalNode INT() { return getToken(EnquantoParser.INT, 0); }
		public InteiroContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterInteiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitInteiro(this);
		}
	}
	public static class OpBinContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public OpBinContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterOpBin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitOpBin(this);
		}
	}
	public static class IdContext extends ExpressaoContext {
		public TerminalNode ID() { return getToken(EnquantoParser.ID, 0); }
		public IdContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitId(this);
		}
	}
	public static class ExpParContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExpParContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterExpPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitExpPar(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		return expressao(0);
	}

	private ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expressao, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new InteiroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(85);
				match(INT);
				}
				break;
			case T__21:
				{
				_localctx = new LeiaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(T__21);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(ID);
				}
				break;
			case T__27:
				{
				_localctx = new ExpParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(T__27);
				setState(89);
				expressao(0);
				setState(90);
				match(T__28);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(94);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(95);
						match(T__22);
						setState(96);
						expressao(7);
						}
						break;
					case 2:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(97);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(98);
						match(T__23);
						setState(99);
						expressao(6);
						}
						break;
					case 3:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(100);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(101);
						match(T__24);
						setState(102);
						expressao(5);
						}
						break;
					case 4:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(103);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(104);
						match(T__25);
						setState(105);
						expressao(4);
						}
						break;
					case 5:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(106);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(107);
						match(T__26);
						setState(108);
						expressao(3);
						}
						break;
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	 
		public BoolContext() { }
		public void copyFrom(BoolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ELogicoContext extends BoolContext {
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public ELogicoContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterELogico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitELogico(this);
		}
	}
	public static class BooleanoContext extends BoolContext {
		public BooleanoContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterBooleano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitBooleano(this);
		}
	}
	public static class NaoLogicoContext extends BoolContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public NaoLogicoContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterNaoLogico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitNaoLogico(this);
		}
	}
	public static class OpRelContext extends BoolContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public OpRelContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterOpRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitOpRel(this);
		}
	}
	public static class BoolParContext extends BoolContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolParContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).enterBoolPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnquantoListener ) ((EnquantoListener)listener).exitBoolPar(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		return bool(0);
	}

	private BoolContext bool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolContext _localctx = new BoolContext(_ctx, _parentState);
		BoolContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_bool, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				{
				_localctx = new OpRelContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				expressao(0);
				setState(117);
				match(T__31);
				setState(118);
				expressao(0);
				}
				break;
			case 3:
				{
				_localctx = new OpRelContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				expressao(0);
				setState(121);
				match(T__32);
				setState(122);
				expressao(0);
				}
				break;
			case 4:
				{
				_localctx = new NaoLogicoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(T__33);
				setState(125);
				bool(3);
				}
				break;
			case 5:
				{
				_localctx = new BoolParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(T__27);
				setState(127);
				bool(0);
				setState(128);
				match(T__28);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ELogicoContext(new BoolContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_bool);
					setState(132);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(133);
					match(T__34);
					setState(134);
					bool(3);
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		case 4:
			return bool_sempred((BoolContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bool_sempred(BoolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u008f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\3\5\3\22\n\3\7\3\24\n"+
		"\3\f\3\16\3\27\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4&\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\48\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4D\n\4\f\4\16"+
		"\4G\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4U\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5_\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5p\n\5\f\5\16\5s\13\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0085\n\6\3\6\3\6\3"+
		"\6\7\6\u008a\n\6\f\6\16\6\u008d\13\6\3\6\2\4\b\n\7\2\4\6\b\n\2\3\3\2 "+
		"!\2\u00a3\2\f\3\2\2\2\4\16\3\2\2\2\6T\3\2\2\2\b^\3\2\2\2\n\u0084\3\2\2"+
		"\2\f\r\5\4\3\2\r\3\3\2\2\2\16\25\5\6\4\2\17\21\7\3\2\2\20\22\5\6\4\2\21"+
		"\20\3\2\2\2\21\22\3\2\2\2\22\24\3\2\2\2\23\17\3\2\2\2\24\27\3\2\2\2\25"+
		"\23\3\2\2\2\25\26\3\2\2\2\26\5\3\2\2\2\27\25\3\2\2\2\30\31\7\'\2\2\31"+
		"\32\7\4\2\2\32U\5\b\5\2\33U\7\5\2\2\34\35\7\6\2\2\35\36\5\n\6\2\36\37"+
		"\7\7\2\2\37%\5\6\4\2 !\7\b\2\2!\"\5\n\6\2\"#\7\7\2\2#$\5\6\4\2$&\3\2\2"+
		"\2% \3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\7\t\2\2()\5\6\4\2)U\3\2\2\2*+\7\n"+
		"\2\2+,\5\n\6\2,-\7\13\2\2-.\5\6\4\2.U\3\2\2\2/\60\7\f\2\2\60\61\7\'\2"+
		"\2\61\62\7\r\2\2\62\63\5\b\5\2\63\64\7\16\2\2\64\67\5\b\5\2\65\66\7\17"+
		"\2\2\668\5\b\5\2\67\65\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\13\2\2:;\5\6"+
		"\4\2;U\3\2\2\2<=\7\20\2\2=E\5\b\5\2>?\7\21\2\2?@\5\b\5\2@A\7\22\2\2AB"+
		"\5\6\4\2BD\3\2\2\2C>\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2G"+
		"E\3\2\2\2HI\7\23\2\2IJ\7\22\2\2JK\5\6\4\2KU\3\2\2\2LM\7\24\2\2MU\7(\2"+
		"\2NO\7\25\2\2OU\5\b\5\2PQ\7\26\2\2QR\5\4\3\2RS\7\27\2\2SU\3\2\2\2T\30"+
		"\3\2\2\2T\33\3\2\2\2T\34\3\2\2\2T*\3\2\2\2T/\3\2\2\2T<\3\2\2\2TL\3\2\2"+
		"\2TN\3\2\2\2TP\3\2\2\2U\7\3\2\2\2VW\b\5\1\2W_\7&\2\2X_\7\30\2\2Y_\7\'"+
		"\2\2Z[\7\36\2\2[\\\5\b\5\2\\]\7\37\2\2]_\3\2\2\2^V\3\2\2\2^X\3\2\2\2^"+
		"Y\3\2\2\2^Z\3\2\2\2_q\3\2\2\2`a\f\b\2\2ab\7\31\2\2bp\5\b\5\tcd\f\7\2\2"+
		"de\7\32\2\2ep\5\b\5\bfg\f\6\2\2gh\7\33\2\2hp\5\b\5\7ij\f\5\2\2jk\7\34"+
		"\2\2kp\5\b\5\6lm\f\4\2\2mn\7\35\2\2np\5\b\5\5o`\3\2\2\2oc\3\2\2\2of\3"+
		"\2\2\2oi\3\2\2\2ol\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\t\3\2\2\2sq"+
		"\3\2\2\2tu\b\6\1\2u\u0085\t\2\2\2vw\5\b\5\2wx\7\"\2\2xy\5\b\5\2y\u0085"+
		"\3\2\2\2z{\5\b\5\2{|\7#\2\2|}\5\b\5\2}\u0085\3\2\2\2~\177\7$\2\2\177\u0085"+
		"\5\n\6\5\u0080\u0081\7\36\2\2\u0081\u0082\5\n\6\2\u0082\u0083\7\37\2\2"+
		"\u0083\u0085\3\2\2\2\u0084t\3\2\2\2\u0084v\3\2\2\2\u0084z\3\2\2\2\u0084"+
		"~\3\2\2\2\u0084\u0080\3\2\2\2\u0085\u008b\3\2\2\2\u0086\u0087\f\4\2\2"+
		"\u0087\u0088\7%\2\2\u0088\u008a\5\n\6\5\u0089\u0086\3\2\2\2\u008a\u008d"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\13\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\r\21\25%\67ET^oq\u0084\u008b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}