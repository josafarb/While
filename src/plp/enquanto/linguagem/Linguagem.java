package plp.enquanto.linguagem;

import java.util.*;

public interface Linguagem {
	final Map<String, Integer> ambiente = new HashMap<>();
	final Scanner scanner = new Scanner(System.in);

	interface Bool {
		public boolean getValor();
	}

	interface Comando {
		public void execute();
	}

	interface Expressao {
		public int getValor();
	}

	abstract class ExpBin implements Expressao {
		protected Expressao esq;
		protected Expressao dir;

		public ExpBin(Expressao esq, Expressao dir) {
			this.esq = esq;
			this.dir = dir;
		}
	}

	class Programa {
		private List<Comando> comandos;

		public Programa(List<Comando> comandos) {
			this.comandos = comandos;
		}

		public void execute() {
			for (Comando comando : comandos) {
				if (comando != null)
					comando.execute();
			}
		}
	}

	class Se implements Comando {
		private Bool condicao;
		private Comando entao;
		private Comando senao;

		public Se(Bool condicao, Comando entao, Comando senao) {
			this.condicao = condicao;
			this.entao = entao;
			this.senao = senao;
		}

		@Override
		public void execute() {
			if (condicao.getValor())
				entao.execute();
			else
				senao.execute();
		}
	}

	Skip skip = new Skip();

	class Skip implements Comando {
		@Override
		public void execute() {
		}
	}

	class QuebrarException extends RuntimeException {
		int contador = 0;

		public QuebrarException(int contador) {
			this.contador = contador;
		}

		public int getContador() {
			return contador;
		}

		public void decrementarContador() {
			this.contador--;
		}
	}

	class Quebrar implements Comando {
		int contador;

		public Quebrar(int contador) {
			this.contador = contador;
		}

		@Override
		public void execute() {
			throw new QuebrarException(this.contador);
		}
	}

	class Escreva implements Comando {
		private Expressao exp;

		public Escreva(Expressao exp) {
			this.exp = exp;
		}

		@Override
		public void execute() {
			System.out.println(exp.getValor());
		}
	}

	class Enquanto implements Comando {
		private Bool condicao;
		private Comando faca;

		public Enquanto(Bool condicao, Comando faca) {
			this.condicao = condicao;
			this.faca = faca;
		}

		@Override
		public void execute() {
			while (condicao.getValor()) {
				try {
					faca.execute();
				} catch (QuebrarException e) {
					e.decrementarContador();
					if (e.getContador() > 0)
						throw e;
				}
			}
		}
	}

	class Para implements Comando {
		private String id;
		private Expressao inicio;
		private Expressao fim;
		private Expressao passo;
		private Comando faca;

		public Para(String id, Expressao inicio, Expressao fim, Expressao passo, Comando faca) {
			this.id = id;
			this.inicio = inicio;
			this.fim = fim;
			this.passo = passo;
			this.faca = faca;
		}

		@Override
		public void execute() {
			int passo = (this.passo == null ? 1 : this.passo.getValor());
			try {
				if (passo > 0) {
					for (int i = this.inicio.getValor(); i <= (this.fim.getValor()); i += passo) {
						ambiente.put(this.id, i);
						this.faca.execute();
						i = ambiente.get(this.id);
					}
				} else {
					for (int i = this.inicio.getValor(); i >= (this.fim.getValor()); i += passo) {
						ambiente.put(this.id, i);
						this.faca.execute();
						i = ambiente.get(this.id);
					}
				}
			} catch (QuebrarException e) {
				e.decrementarContador();
				if (e.getContador() > 0)
					throw e;
			}
		}
	}

	class Caso implements Comando {
		private Expressao expressao;

		private Comando comando;

		public Caso(Expressao expressao, Comando comando) {
			this.expressao = expressao;
			this.comando = comando;
		}

		@Override
		public void execute() {
			this.comando.execute();
		}
	}

	class Escolha implements Comando {
		private Expressao expressao;
		private List<Caso> casos;
		private Caso outro;

		public Escolha(Expressao expressao) {
			this.expressao = expressao;
			this.casos = new ArrayList<>();
			this.outro = null;
		}

		public void adicionar(Caso caso) {
			this.casos.add(caso);
		}

		public void outro(Caso outro) {
			this.outro = outro;
		}

		@Override
		public void execute() {
			int valorExpressao = this.expressao.getValor();
			for (Caso caso : this.casos) {
				if (caso.expressao.getValor() == valorExpressao) {
					caso.comando.execute();
					return;
				}
			}
			if (this.outro != null)
				this.outro.execute();
		}
	}

	class Exiba implements Comando {
		public Exiba(String texto) {
			this.texto = texto;
		}

		private String texto;

		@Override
		public void execute() {
			System.out.println(texto);
		}
	}

	class Bloco implements Comando {
		private List<Comando> comandos;

		public Bloco(List<Comando> comandos) {
			this.comandos = comandos;
		}

		@Override
		public void execute() {
			for (Comando comando : comandos) {
				comando.execute();
			}
		}
	}

	class Atribuicao implements Comando {
		private String id;
		private Expressao exp;

		public Atribuicao(String id, Expressao exp) {
			this.id = id;
			this.exp = exp;
		}

		@Override
		public void execute() {
			ambiente.put(id, exp.getValor());
		}
	}

	class Inteiro implements Expressao {
		private int valor;

		public Inteiro(int valor) {
			this.valor = valor;
		}

		@Override
		public int getValor() {
			return valor;
		}
	}

	class Id implements Expressao {
		private String id;

		public Id(String id) {
			this.id = id;
		}

		@Override
		public int getValor() {
			final Integer v = ambiente.get(id);
			final int valor;
			if (v != null)
				valor = v;
			else
				valor = 0;

			return valor;
		}
	}

	Leia leia = new Leia();

	class Leia implements Expressao {
		@Override
		public int getValor() {
			return scanner.nextInt();
		}
	}

	class ExpSoma extends ExpBin {
		public ExpSoma(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return esq.getValor() + dir.getValor();
		}
	}

	class ExpSub extends ExpBin {
		public ExpSub(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return esq.getValor() - dir.getValor();
		}
	}

	class ExpMult extends ExpBin {
		public ExpMult(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return esq.getValor() * dir.getValor();
		}
	}

	class Booleano implements Bool {
		private boolean valor;

		public Booleano(boolean valor) {
			this.valor = valor;
		}

		@Override
		public boolean getValor() {
			return valor;
		}
	}

	abstract class ExpRel implements Bool {
		protected Expressao esq;
		protected Expressao dir;

		public ExpRel(Expressao esq, Expressao dir) {
			this.esq = esq;
			this.dir = dir;
		}
	}

	public class ExpIgual extends ExpRel {

		public ExpIgual(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public boolean getValor() {
			return esq.getValor() == dir.getValor();
		}

	}

	public class ExpMenorIgual extends ExpRel {
		public ExpMenorIgual(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public boolean getValor() {
			return esq.getValor() <= dir.getValor();
		}
	}

	public class NaoLogico implements Bool {
		private Bool b;

		public NaoLogico(Bool b) {
			this.b = b;
		}

		@Override
		public boolean getValor() {
			return !b.getValor();
		}
	}

	public class ELogico implements Bool {
		private Bool esq;
		private Bool dir;

		public ELogico(Bool esq, Bool dir) {
			this.esq = esq;
			this.dir = dir;
		}

		@Override
		public boolean getValor() {
			return esq.getValor() && dir.getValor();
		}

	}

	class ExpDivisao extends ExpBin { // questão 1
		public ExpDivisao(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return esq.getValor() / dir.getValor();
		}
	}

	class ExpPonenciacao extends ExpBin { // questão 2
		public ExpPonenciacao(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return (int) Math.pow(esq.getValor(), dir.getValor());

		}
	}

	 class OuLogico implements Bool { // questão 3
		private Bool esq;
		private Bool dir;

		public OuLogico(Bool esq, Bool dir) {
			this.esq = esq;
			this.dir = dir;
		}

		@Override
		public boolean getValor() {
			return esq.getValor() || dir.getValor();
		}
	}

	 class XorLogico implements Bool { // questão 4
		private Bool esq;
		private Bool dir;

		public XorLogico(Bool esq, Bool dir) {
			this.esq = esq;
			this.dir = dir;
		}

		@Override
		public boolean getValor() {
			return (!esq.getValor() == dir.getValor());
		}
	}

	 class ExpMaiorIgual extends ExpRel { // questão 5
		public ExpMaiorIgual(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public boolean getValor() {
			return esq.getValor() >= dir.getValor();
		}
	}

	 class ExpDiferente extends ExpRel { // questão 6
		public ExpDiferente(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public boolean getValor() {
			return esq.getValor() != dir.getValor();
		}
	}
}
