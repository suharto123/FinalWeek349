
public abstract class Item {
    private String name;
    private String effectPrint;
    private Character symbol;

    protected Item(String name, String effectPrint, Character symbol) {
        this.name = name;
        this.setEffectPrint(effectPrint);
        this.symbol = symbol;
    }

    public String getName(){
        return this.name;
    }

    public Character getSymbol(){
        return this.symbol;
    }

	public void interact(DungeonCharacter creature) {
		// TODO Auto-generated method stub
		
	}

	public String getEffectPrint() {
		return effectPrint;
	}

	public void setEffectPrint(String effectPrint) {
		this.effectPrint = effectPrint;
	}



}
