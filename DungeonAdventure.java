
public class DungeonAdventure
{
    public static void main(String[] args) {
    	do {
			System.out.println("Welcome to Dungeon Adventure (made by Suharto Suharto and Quinton Tiller!)\n\n" + "The objective of this " +
					"game is to escape a dungeon you have been trapped in.\n" +"The Dungeon has a size of 5x5! " +"Along the route " +
					"you will be tasked with fighting monsters as well as finding " +
					"all the pillars of OO to escape. \n" +
					"To help you along the way, there are items you can collect such as health/vision potions! \n" +
					"To win, find all the legendary pillars of OO and make your way to the exit without dying!\n" +
					"To begin, choose a type of hero (each with their own special skills) " +
					"as well as a name for your character to start the game!\n");
			printMapLegend();		
			Hero ahero= chooseHero();
			Dungeon dungeon= new Dungeon(ahero);
			dungeon.printDungeonroom();
			dungeon.printHeroLocation();
			int menuNum;
			do {
				menuNum=menu();

				if(menuNum==1) {
					move(dungeon);
					dungeon.printDungeonroom();
					dungeon.enterRoom();
					dungeon.printHeroLocation();
				}
				if(menuNum==2) {
					ahero.useHealthPotion();
				}
				if(menuNum==3) {
					ahero.useVisionPotion();
					
				}
				if(menuNum==5) { 
					dungeon.displayTheDungeon();
					printMapLegend();
				}

			} while(ahero.isAlive() && !dungeon.gameComplete() && menuNum!=4 && (menuNum>0 || menuNum<5 ));

			dungeon.displayTheDungeon();


		} while (playAgain());
	}//end main game loop

  


    public static Hero chooseHero() {
		int choice;

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
		choice = Keyboard.readInt();

		switch(choice) {
			case 1: return HeroFactory.WARRIOR.make();

			case 2: return HeroFactory.SORCERESS.make();

			case 3: return HeroFactory.THIEF.make();

			default:
				Hero h = HeroFactory.rand();
				System.out.println("invalid choice, returning " + h.getClass());
				return h;
		}
	}

	public static boolean playAgain() {
		char again;

		System.out.println("Would you like to play again? Enter y for Yes and n for No");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}

	public static int menu() {
		int choice;
		do {
			System.out.println("1) Move Room");
			System.out.println("2) Use Health Potion");
			System.out.println("3) Use Vision Potion");
			System.out.println("4) Exit");
			choice=Keyboard.readInt();
		}while (choice<0 || choice>5);
		return choice;
	}
	
	public static void printMapLegend() {
		System.out.println("Legend:\n#-Pillars\nL-Health Potions\nP-Pits\nV-Vision Potions" + "\nM-Monsters\nI-Entrance\nE-Exit\nH-Hero Location\n");
	}

	public static void move(Dungeon dungeon) {
		int choice;
			do {

				System.out.println(" Which way do you want to move?");
				System.out.println("1) Up");
				System.out.println("2) Down");
				System.out.println("3) Left");
				System.out.println("4) Right");
				choice = Keyboard.readInt();
				if(checkmove(dungeon,choice) != true) {
					System.out.println("invalid move!");
				}
			} 
			while (!checkmove(dungeon,choice));

			int[] loc=dungeon.getTheHero().getLocationpoints();
			int r=loc[0];
			int c=loc[1];
			int newRow;
			int newColumn;

			if(choice==1) {
				newRow=r-1;
				dungeon.getTheHero().setLocationpoints(newRow,c);
			}
			else if(choice==2) {
				newRow=r+1;
				dungeon.getTheHero().setLocationpoints(newRow,c);
			}
			else if(choice==3) {
				newColumn=c-1;
				dungeon.getTheHero().setLocationpoints(r,newColumn);
			}
			else if(choice==4) {
				newColumn=c+1;
				dungeon.getTheHero().setLocationpoints(r,newColumn);
			}
	}

	public static boolean checkmove(Dungeon dungeon,int choice) {
		int[] loc=dungeon.getTheHero().getLocationpoints();
		int row=loc[0];
		int column=loc[1];
		boolean answer=true;
		if(choice==1) {
			if(row<=0) {
				answer=false;
			}

		}
		else if(choice==2) {
			if(row >= 4) {
				answer=false;
			}

		}
		else if(choice==3) {
			if(column <= 0) {
				answer=false;
			}

		}
		else if(choice==4) {
			if(column >= 4) {
				answer=false;
			}

		}
		else {
			answer=false;
		}
		return answer;
	}

}