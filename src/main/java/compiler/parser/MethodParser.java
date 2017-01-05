package compiler.parser;

import compiler.block.Block;
import compiler.block.method.MethodBlock;
import compiler.tokenizer.Tokenizer;

public class MethodParser extends Parser<MethodBlock> {

	@Override
	public boolean shouldParse(String line) {



		return line.matches("void [a-zA-Z][a-zA-Z0-9]*[ ]*\\([a-zA-Z][a-zA-Z0-9]*[ ]+[a-zA-Z][a-zA-Z0-9]*[ ]*\\)[ ]*:");
	}



	@Override
	public MethodBlock parse(Block superBlock, Tokenizer tokenizer) {

		String type = tokenizer.nextToken().getToken();
		
		String name = tokenizer.nextToken().getToken(); // Get the string value of the next token.
		
		return new MethodBlock(superBlock, name, type, null);
	}
}