import java.util.concurrent.ThreadLocalRandom;


public abstract class Hero extends DungeonCharacter {
    private double chanceToBlock;
    private int healthPotionCount = 0;
    private int visionPotionCount= 0;
    private int pillarsCount = 0;
    private int pitDamage;
    private int numberOfTurns;
    private SecondaryMove specialSkill;
    private int[] coords;


    public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        setChanceToBlock(chanceToBlock);
        readCharacterName();
        coords = new int[2];
    }

    protected abstract void setHealthPotions(int i);

	public int[] getLocationpoints() {
        return coords;
    }

    public void setLocationpoints(int row, int column) {
        int[] newLoc = new int[2];
        newLoc[0] = row;
        newLoc[1] = column;
        coords = newLoc;
    }

    public void setChanceToBlock(double chanceToBlock) {
        this.chanceToBlock = chanceToBlock;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }
    
    
    
    public int getRandomPitDamage() {
        return pitDamage;
    }
    
    public void setRandomPitDamage() {
        pitDamage = ThreadLocalRandom.current().nextInt(1, 20 + 1);;
    }


  

    public void readCharacterName() {
        String name;
        System.out.print("Enter your character's name: ");
        name = Keyboard.readString();
        setName(name);
    }


    public boolean defend() {
        return Math.random() <= chanceToBlock;

    }

    public void subtractHitPoints(int hitPoints) {
        if (defend()) {
            System.out.println(getName() + " blocked the incoming attack!");
        } 
        else {
            super.subtractHP(hitPoints);
        }


    }
    
    public void useHealthPotion() {
        if (this.healthPotionCount == 0) {
            System.out.println("No health potions available!");
        } 
        else {
            setHealthPotion(this.healthPotionCount--);
            int healPoints = ThreadLocalRandom.current().nextInt(5, 15 + 1);
            setHitPoints(getHitPoints() + healPoints);
        }

    }
    
    public void useVisionPotion() {
        int curVisionPotion = visionPotionCount;
        if (curVisionPotion == 0) {
            System.out.println("No vision potions available!");
        } 
        else {
            setVisionPotion(curVisionPotion--);
        }

    }

    public abstract void battleChoices(DungeonCharacter enemy, Hero hero);

    public void checkNumberofTurns(DungeonCharacter enemy) {
        numberOfTurns = getAttackSpeed() / enemy.getAttackSpeed();

        if (numberOfTurns == 0) {
        	 numberOfTurns++;
        }
           

        System.out.println("Number of turns left this round is: " + numberOfTurns);
        setNumberOfTurns(numberOfTurns);
    }

    public String toString() {
        return "Hero Name:" + getName() + " HP:" + getHitPoints() + "\n " + "# of Pillars in Hand:" + getPillars() +  "\n " + " Health Potions:" + getHealthPotion() +  "\n " + " Vision Potions:" + getVisionPotion() +  "\n ";
    }

	public int getVisionPotion() {
		return visionPotionCount;
	}

	public void setVisionPotion(int visionPotionCount) {
		this.visionPotionCount = visionPotionCount;
	}

	public int getHealthPotion() {
		return healthPotionCount;
	}

	public void setHealthPotion(int healthPotionCount) {
		this.healthPotionCount = healthPotionCount;
	}
	
	public int getPillars() {
		return pillarsCount;
	}

	public void setPillars(int pillarsCount) {
		this.pillarsCount = pillarsCount;
	}

	public SecondaryMove getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(SecondaryMove specialSkill) {
		this.specialSkill = specialSkill;
	}

}