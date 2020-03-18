
public class Thief extends Hero {
	

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);
		setSpecialSkill(new SurpriseAttack());
		

    }
    
	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " sneakily swipes at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}


    public void battleChoices(DungeonCharacter opponent,Hero hero)
	{
		int choice;
		checkNumberofTurns(opponent);
		int turns=getNumberOfTurns();


		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: getSpecialSkill().useSkill(opponent,hero);
			        break;
			    default:
			        System.out.println("Please select a valid attack option!");
		    }

			turns--;
			if (turns > 0) {
			    System.out.println("Number of turns remaining is: " + turns);

			}
		} 
		while(turns > 0);

    }

	@Override
	protected void setHealthPotions(int i) {
		// TODO Auto-generated method stub
		
	}





	
}