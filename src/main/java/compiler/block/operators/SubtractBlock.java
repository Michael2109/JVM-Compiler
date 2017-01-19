package compiler.block.operators;

import compiler.block.Block;

public class SubtractBlock extends Block {

    private String type = "subtract";
    private String value;
    private String name;

    public SubtractBlock(Block superBlock, String name, String value) {
        super(superBlock, false, false);
        this.name = name;
        this.value = value;
    }

    @Override
    public void init() {

    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getOpeningCode() {
        return null;
    }

    @Override
    public String getBodyCode() {
        return "mv.visitLdcInsn(" + value + ");\n" +
                "mv.visitVarInsn(ILOAD," + getId() + ");\n" +
                "mv.visitInsn(ISUB);\n" +
                "mv.visitVarInsn(ISTORE," + getId() + ");\n";
    }

    @Override
    public String getClosingCode() {
        return null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "subtract: " + name;
    }
}
