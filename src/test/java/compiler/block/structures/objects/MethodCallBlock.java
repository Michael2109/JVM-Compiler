package compiler.block.structures.objects;

/**
 * Calling of a method within the class
 */
public class MethodCallBlock extends Block {

    private String name, type;
    private Parameter[] params;

    public MethodCallBlock(Block superBlock, String name, String type, Parameter[] params) {
        super(superBlock, false, false);

        this.name = name;
        this.type = type;
        this.params = params;

    }

    public Parameter[] getParameters() {
        return params;
    }

    @Override
    public void init() {

    }

    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return null;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getOpeningCode() {
        return "";
    }

    @Override
    public String getBodyCode() {
        return name + "();";
    }

    @Override
    public String getClosingCode() {
        return "";
    }

}