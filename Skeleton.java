
public class Skeleton extends Monster
{

    public Skeleton()
	{
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);

    }
    
    public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings his sword with his bony arms at " + opponent.getName() + ":");
		super.attack(opponent);

	}

}//end class Skeleton