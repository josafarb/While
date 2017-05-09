package plp.enquanto.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import plp.enquanto.linguagem.Linguagem.*;

public class MeuListener extends EnquantoBaseListener {
	private final Leia leia = new Leia();
	private final Skip skip = new Skip();
	private final ParseTreeProperty<Object> values = new ParseTreeProperty<>();

	private Programa programa;
	private List<ErrorNode> errors;

	public MeuListener()
	{
		this.errors = new ArrayList<>();
	}

	public Programa getPrograma() {
		return programa;
	}

	public boolean hasError()
	{
		return !this.errors.isEmpty();
	}

	public List<ErrorNode> getErrors()
	{
		return this.errors;
	}

	private void setValue(final ParseTree node, final Object value) {
		values.put(node, value);
	}

	private Object getValue(final ParseTree node) {
		return values.get(node);
	}

	@Override
	public void exitBooleano(final EnquantoParser.BooleanoContext ctx) {
		setValue(ctx, new Booleano(ctx.getText().equals("verdadeiro")));
	}

	@Override
	public void exitLeia(final EnquantoParser.LeiaContext ctx) {
		setValue(ctx, leia);
	}

	@Override
	public void exitSe(final EnquantoParser.SeContext ctx) {
		final Bool condicao = (Bool) getValue(ctx.bool(0));
		final Comando entao = (Comando) getValue(ctx.comando(0));
		Comando senao = null;
		if (ctx.comando().size() == 3)							// Se "senãose" presente
			senao = new Se(
				(Bool) getValue(ctx.bool(1)),
				(Comando) getValue(ctx.comando(1)),
				(Comando) getValue(ctx.comando(2))
			);
		else													// Se "senaose" não presente, tratar como senão.
			senao = (Comando) getValue(ctx.comando(1));
		setValue(ctx, new Se(condicao, entao, senao));
	}

	@Override
	public void exitInteiro(final EnquantoParser.InteiroContext ctx) {
		setValue(ctx, new Inteiro(Integer.parseInt(ctx.getText())));
	}

	@Override
	public void exitSkip(final EnquantoParser.SkipContext ctx) {
		setValue(ctx, skip);
	}

	@Override
	public void exitEscreva(final EnquantoParser.EscrevaContext ctx) {
		final Expressao exp = (Expressao) getValue(ctx.expressao());
		setValue(ctx, new Escreva(exp));
	}

	@Override
	public void exitPrograma(final EnquantoParser.ProgramaContext ctx) {
		@SuppressWarnings("unchecked")
		final List<Comando> cmds = (List<Comando>) getValue(ctx.seqComando());
		programa = new Programa(cmds);
		setValue(ctx, programa);
	}

	@Override
	public void exitId(final EnquantoParser.IdContext ctx) {
		setValue(ctx, new Id(ctx.ID().getText()));
	}

	@Override
	public void exitSeqComando(final EnquantoParser.SeqComandoContext ctx) {
		final List<Comando> comandos = new ArrayList<>();
		for (EnquantoParser.ComandoContext c : ctx.comando()) {
			comandos.add((Comando) getValue(c));
		}
		setValue(ctx, comandos);
	}

	@Override
	public void exitAtribuicao(final EnquantoParser.AtribuicaoContext ctx) {
		final String id = ctx.ID().getText();
		final Expressao exp = (Expressao) getValue(ctx.expressao());
		setValue(ctx, new Atribuicao(id, exp));
	}

	@Override
	public void exitBloco(final EnquantoParser.BlocoContext ctx) {
		@SuppressWarnings("unchecked")
		final List<Comando> cmds = (List<Comando>) getValue(ctx.seqComando());
		setValue(ctx, new Bloco(cmds));
	}

	@Override
	public void exitOpBin(final EnquantoParser.OpBinContext ctx) {
		final Expressao esq = (Expressao) getValue(ctx.expressao(0));
		final Expressao dir = (Expressao) getValue(ctx.expressao(1));
		final String op = ctx.getChild(1).getText();
		final ExpBin exp;
		switch (op) {
		case "+":
			exp = new ExpSoma(esq, dir);
			break;
		case "*":
			exp = new ExpMult(esq, dir);
			break;
		case "-":
			exp = new ExpSub(esq, dir);
			break;
		case "/":
			exp = new ExpDivisao(esq,dir);
			break;
		case "^":
			exp = new ExpPonenciacao(esq,dir);
			break;
		default:
			exp = new ExpSoma(esq, dir);
		}
		setValue(ctx, exp);
	}

	@Override
	public void exitEnquanto(final EnquantoParser.EnquantoContext ctx) {
		final Bool condicao = (Bool) getValue(ctx.bool());
		final Comando comando = (Comando) getValue(ctx.comando());
		setValue(ctx, new Enquanto(condicao, comando));
	}

	@Override
	public void exitELogico(final EnquantoParser.ELogicoContext ctx) {
		final Bool esq = (Bool) getValue(ctx.bool(0));
		final Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new ELogico(esq, dir));
	}
	
	@Override
	public void exitOuLogico(final EnquantoParser.OuLogicoContext ctx) {
		final Bool esq = (Bool) getValue(ctx.bool(0));
		final Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new ELogico(esq, dir));
	}
	
	
	@Override
	public void exitXorLogico(final EnquantoParser.XorLogicoContext ctx) {
		final Bool esq = (Bool) getValue(ctx.bool(0));
		final Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new ELogico(esq, dir));
	}


	@Override
	public void exitBoolPar(final EnquantoParser.BoolParContext ctx) {
		setValue(ctx, getValue(ctx.bool()));
	}

	@Override
	public void exitNaoLogico(final EnquantoParser.NaoLogicoContext ctx) {
		final Bool b = (Bool) getValue(ctx.bool());
		setValue(ctx, new NaoLogico(b));
	}

	@Override
	public void exitExpPar(final EnquantoParser.ExpParContext ctx) {
		setValue(ctx, getValue(ctx.expressao()));
	}

	@Override
	public void exitExiba(final EnquantoParser.ExibaContext ctx) {
		final String t = ctx.Texto().getText();
		final String texto = t.substring(1, t.length() - 1);
		setValue(ctx, new Exiba(texto));
	}

	@Override
	public void exitOpRel(final EnquantoParser.OpRelContext ctx) {
		final Expressao esq = (Expressao) getValue(ctx.expressao(0));
		final Expressao dir = (Expressao) getValue(ctx.expressao(1));
		final String op = ctx.getChild(1).getText();
		final ExpRel exp;
		switch (op) {
		case "=":
			exp = new ExpIgual(esq, dir);
			break;
		case "<=":
			exp = new ExpMenorIgual(esq, dir);
			break;
		case ">=":
			exp = new ExpMaiorIgual(esq, dir);
			break;
		case "<>":
			exp = new ExpDiferente(esq, dir);
			break;
		default:
			exp = new ExpIgual(esq, dir);
		}
		setValue(ctx, exp);
	}

	@Override
	public void enterPara(EnquantoParser.ParaContext ctx)
	{
		super.enterPara(ctx);
	}

	@Override
	public void exitPara(EnquantoParser.ParaContext ctx)
	{
		final String id = ctx.ID().getText();
		final Expressao inicio = (Expressao) getValue(ctx.expressao(0));
		final Expressao fim = (Expressao) getValue(ctx.expressao(1));
		Expressao passo = null;
		if (ctx.expressao().size() > 2)
			passo = (Expressao) getValue(ctx.expressao(2));
		final Comando faca = (Comando) getValue(ctx.comando());
		setValue(ctx, new Para(id, inicio, fim, passo, faca));
	}

	@Override
	public void exitEscolha(EnquantoParser.EscolhaContext ctx)
	{
		final Expressao expressao = (Expressao) getValue(ctx.expressao(0));
		Escolha escolha = new Escolha(expressao);
		for (int i = 1; i < ctx.expressao().size(); i++) 		// Casos
			escolha.adicionar(new Caso((Expressao) getValue(ctx.expressao(i)), (Comando) getValue(ctx.comando(i-1))));
		if (ctx.comando().size() == ctx.expressao().size())		// Caso "outro"
			escolha.outro(new Caso(null, (Comando) getValue(ctx.comando(ctx.comando().size()-1))));
		setValue(ctx, escolha);
	}

	@Override
	public void visitErrorNode(ErrorNode node)
	{
		this.errors.add(node);
	}

	@Override
	public void exitQuebrar(EnquantoParser.QuebrarContext ctx)
	{
		int contador = 1;
		if (ctx.INT() != null)
			contador = Integer.parseInt(ctx.INT().getText());
		setValue(ctx, new Quebrar(contador));
	}
}
