

public class Warrior extends Hero {

    public Warrior() {

		super("Warrior", 125, 4, .8, 35, 60, .2);
		setSpecialSkill(new CrushingBlow());

    }

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}

    public void battleChoices(DungeonCharacter opponent,Hero hero) {
		int choice;
		checkNumberofTurns(opponent);
		int turns= getNumberOfTurns();


		do {
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice) {
			    case 1: attack(opponent);
			        break;
			    case 2: getSpecialSkill().useSkill(opponent,hero);
			        break;
			    default:
			        System.out.println("invalid choice!");
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