
public class Sorceress extends Hero
{

    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);
		setSpecialSkill(new IncreaseHP());

    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " performs a spell to cast fireballs at " + opponent.getName() + ":");
		super.attack(opponent);
	}


    public void battleChoices(DungeonCharacter opponent,Hero hero)
	{
		hero.checkNumberofTurns(opponent);
		int choice;
		int turns=getNumberOfTurns();

		while(turns > 0 && turns > 0 && opponent.getHitPoints() > 0) {
			
			System.out.print("Choose an option: ");
		    System.out.println("1. Attack Enemy");
		    System.out.println("2. Increase HP");
		    choice = Keyboard.readInt();

		    if (choice == 1) {
		    	attack(opponent);
		    }
		    if (choice == 2) {
		    	getSpecialSkill().useSkill(opponent, hero);
		    }
		    else {
		    	 System.out.println("invalid choice!");
		    }

			turns--;
		    if (turns > 0)
			    System.out.println("Number of turns remaining is: " + turns);
		}

    }



	@Override
	protected void setHealthPotions(int i) {
		// TODO Auto-generated method stub
		
	}

}