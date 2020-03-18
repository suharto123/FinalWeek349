

public class Ogre extends Monster {

    public Ogre() {
    	super("Oscar the Ogre", 200, 2, .5, .2, 25, 55, 20, 40);
	}
    
    public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " clumsily attacks  " + opponent.getName() + ":");
		super.attack(opponent);

	}
}