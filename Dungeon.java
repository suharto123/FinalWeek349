public class Dungeon
{
    private Room[][] dungeon;
    private Hero hero;
    private Integer rows = 0;
    private Integer columns = 0;

    public Dungeon(Hero hero)
    {
        createDungeon(5,5);
        setTheHero(hero);
        placePillars();
        setExit();
        heroPlacement();
    }
    
    public Dungeon() {
    	createDungeon(5,5);
        setTheHero(hero);
        placePillars();
        setExit();
        //heroPlacement();
    }

	public Room[][] createDungeon(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
        dungeon = new Room[rows][columns];

        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<columns;c++)
            {
                dungeon[r][c]=new Room(r,c,' ');
            }
        }

        return dungeon;
    }

    public void setTheHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getTheHero() {
        return hero;
    }
    
    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }
   
    public void placePillars() {
        dungeon[3][0].setItem('#');
        dungeon[2][2].setItem('#');
        dungeon[1][3].setItem('#');
        dungeon[4][2].setItem('#');
    }

    public void heroPlacement() {
        int row=(int)(Math.random() * 5) ;
        int column=(int)(Math.random() * 5);
        if(dungeon[row][column].getitem() == '#' || dungeon[row][column].getitem() == 'E') {
            if(column < 4) {
                column++;
            }
            else if(column > 0) {
            	column--;
            }
                
        }
        if(dungeon[row][column].getitem()==' '|| dungeon[row][column].getitem() == 'M' || dungeon[row][column].getitem() == 'L' || dungeon[row][column].getitem() == 'P') {
            dungeon[row][column].setItem('I');
        }
        hero.setLocationpoints(row,column);
    }
    

    public void setExit() {
      dungeon[4][0].setItem('E');
    }

    public boolean gameComplete() {
        int[] location = hero.getLocationpoints();
        return hero.getPillars() == 4 && location[0] == 4 & location[1] == 0;
    }

    public void printDungeonroom() {
        int[] heroloc=hero.getLocationpoints();

        int r=heroloc[0];
        int c=heroloc[1];
        String room=dungeon[r][c].toString();
        System.out.println(room);
    }
    //Press 5 to use this
    public void displayTheDungeon() {
    	System.out.println("Secret Cheat Menu Option Accessed!");
        int[] heroLoc = hero.getLocationpoints();
        dungeon[heroLoc[0]][heroLoc[1]].setItem('H');
        for(int row = 0; row < 5; row ++) {
            String[] rowstr=new String[3];
            rowstr[0] = "";
            rowstr[1] = "";
            rowstr[2] = "";
            for(int c = 0; c < 5; c++) {
                  String[] rowArr = dungeon[row][c].toString().split("\n");
                  rowstr[0] += rowArr[0];
                  rowstr[1] += rowArr[1];
                  rowstr[2] += rowArr[2];
            }
            
            for(int x = 0; x < 3; x++) {
                System.out.println(rowstr[x]);
            }
        }
    }
    
    public void displayVisionPotionEffects() {

        int[] herolocation=hero.getLocationpoints();
        dungeon[herolocation[0]][herolocation[1]].setItem('H');
        for(int row = 0 ;row < 5;row ++) {
            String[] rowstr=new String[3];
            rowstr[0]="";
            rowstr[1]="";
            rowstr[2]="";
            for(int c = 0; c < 5; c++) {
                  String[] rowArr=dungeon[row][c].toString().split("\n");
                  rowstr[0]+=rowArr[0];
                  rowstr[1]+=rowArr[1];
                  rowstr[2]+=rowArr[2];
            }
            
            for(int x=0;x<3;x++) {
                System.out.println(rowstr[x]);
            }
        }
    }

    public void printHeroLocation() {
        int[] heroloc=hero.getLocationpoints();

        int row = heroloc[0];
        int column = heroloc[1];

        System.out.println("you are currently in row # " + row + ", col # " + column);
        System.out.println(hero.toString());
    }

    public void enterRoom() {
        int[] loc=hero.getLocationpoints();
        int r=loc[0];
        int c=loc[1];
        if(dungeon[r][c].getitem()== 'L') {
            int healthPotions=hero.getHealthPotion();
            healthPotions = healthPotions + 1;
            hero.setHealthPotion(healthPotions);
            dungeon[r][c].setItem(' ');
            System.out.println("You Found a Health Potion! It has been added to your inventory");
        }
        else if(dungeon[r][c].getitem()== 'P') {
        	hero.setRandomPitDamage();
            System.out.println("You fell into a pit and took " + hero.getRandomPitDamage() + " damage :(");
            hero.getRandomPitDamage();
        }
        else if(dungeon[r][c].getitem()== 'V') {
        	int visionPot=hero.getVisionPotion();
        	visionPot = visionPot + 1;
            hero.setVisionPotion(visionPot);
            dungeon[r][c].setItem(' ');
            System.out.println("You Found a Vision Potion! It has been added to your inventory");
        }
        else if(dungeon[r][c].getitem()== 'M') {
            System.out.println("A monster appears...");
            Monster aMonster= generateMonster();
            battle(hero,aMonster);
            dungeon[r][c].setItem(' ');
        }
        else if(dungeon[r][c].getitem()== '#') {
            System.out.println("You found one of the four Pillars of OO. The pillar has been placed in your inventory!");
            int pillars = hero.getPillars();
            pillars = pillars + 1;
            hero.setPillars(pillars);
            dungeon[r][c].setItem(' ');
        }
        else if(dungeon[r][c].getitem()== 'E') {
            if(gameComplete() == true) {
                System.out.println("You successfully collected the four pillars of OO! Great job young traveler " + hero.getName() + "!!");
            }
            else
                System.out.println("You do not have all the pillars of OO! Keep searching traveler!");
        }
    }

    public static Monster generateMonster()
	{
		return MonsterFactory.rand();
	}
    

    public void battle(Hero theHero, Monster theMonster) {
        char pause = 'p';
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName());
        System.out.println("---------------------------------------------");


        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q') {

            theHero.battleChoices(theMonster,theHero);


            if (theMonster.isAlive())
                theMonster.attack(theHero);


            System.out.print("\n-->enter q to quit, anything else to continue: ");
            pause = Keyboard.readChar();

        }

        if (!theMonster.isAlive()) {
            System.out.println(theHero.getName() + " won this battle!");
        }
        else if (!theHero.isAlive()) {
            System.out.println(theHero.getName() + " lost this battle!");
        }
        else {
            System.out.println("Quitters never win!!!");
        }

    }

}
