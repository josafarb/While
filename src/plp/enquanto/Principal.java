package plp.enquanto;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import plp.enquanto.parser.EnquantoLexer;
import plp.enquanto.parser.EnquantoParser;
import plp.enquanto.parser.MeuListener;

public class Principal {

	private static ParseTree parse(String path) throws IOException
	{
		final CharStream input = CharStreams.fromFileName(path);
		final EnquantoLexer lexer = new EnquantoLexer(input);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final EnquantoParser parser = new EnquantoParser(tokens);
		return parser.programa();
	}

	public static void main(String... args) throws IOException {

		for (String arg : args) {
			final ParseTree tree = parse(arg);
			final ParseTreeWalker walker = new ParseTreeWalker();
			final MeuListener listener = new MeuListener();
			walker.walk(listener, tree);
			// TODO Checar erros no processo de "parse"
			listener.getPrograma().execute();
		}
	}
}
