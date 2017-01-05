package compiler.block;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a block of code.
 */
public abstract class Block {

	private Block superBlock;
	private ArrayList<Block> subBlocks;

	// true ifs block can store sub blocks
	public boolean isContainer = false;

	public boolean isVariable = false;


	public Block(Block superBlock, boolean isContainer, boolean isVariable) {
		this.superBlock = superBlock;
		this.subBlocks = new ArrayList<>();
		this.isContainer = isContainer;

	}
	
	public Block getSuperBlock() {
		return superBlock;
	}
	
	public ArrayList<Block> getBlockTree() {
		ArrayList<Block> blocks = new ArrayList<Block>();
		
		Block block = this;
		
		do {
			blocks.add(block);
			block = block.getSuperBlock();
		} while (block != null);
		
		Collections.reverse(blocks);
		
		return blocks;
	}
	
	public Block[] getSubBlocks() {
		return subBlocks.toArray(new Block[subBlocks.size()]);
	}
	
	public void addBlock(Block block) {
		subBlocks.add(block);
	}

	public abstract void run();

    public abstract String getName();
	public abstract String getValue();
	public abstract String getType();

	public abstract String getOpeningCode();
	public abstract String getClosingCode();
	public abstract String getBodyCode();

	@Override
	public String toString(){
		return getName() + " " + getValue() + " " + getType();
	}
}