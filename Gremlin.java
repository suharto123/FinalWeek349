

public class Gremlin extends Monster
{

    public Gremlin()
	{
		super("Gnarltooth the Gremlin", 75, 6, .7, .5, 20, 35, 23, 42);

    }

    public void attack(DungeonCharacter opponent)
   	{
   		System.out.println(getName() + " sneakily claws at  " + opponent.getName() + ":");
   		super.attack(opponent);

   	}

}