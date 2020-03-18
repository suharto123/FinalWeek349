import java.util.ArrayList;

public abstract class DungeonCharacter {
	
	private int damageMin;
	private int damageMax;
    private String name;
    private int hp;
    private int speed;
    private double hitProbability;
    protected int vision;
	ArrayList<Item> items;

  
    public DungeonCharacter(String name, int hitPoints, int speed, double hitProbability, int damageMin, int damageMax) {

        setName(name);
        setHitPoints(hitPoints);
        setAttackSpeed(speed);
        hitProb(hitProbability);
        setDamageMin(damageMin);
        setDamageMax(damageMax);
        this.vision = 1;

    }
    
    public int getVision(){
		int x = this.vision;

		if(this.vision > 1)
			this.vision = 1;

		return x;
	}

	public void useItem( int i ){
		this.items.get(i).interact(this);

	}



    public String getName() {
        return name;
    }

    public void setName(String dungeonCharName) {
        this.name = dungeonCharName;
    }

    public void setHitPoints(int hp) {
        this.hp = hp;
    }
    
    public void setAttackSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getHitPoints() {
        return hp;
    }

    
    public int getAttackSpeed() {
        return speed;
    }

    public void hitProb(double chanceToHit) {
        this.hitProbability = chanceToHit;
    }


    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }


    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }

    public void addHP(int hp) {
        if (hp <= 0)
            System.out.println("HP cannot be negative!");
        else {
            this.hp += hp;


        }
    }

    public void subtractHP(int hp) {
        if (hp < 0)
            System.out.println("Hitpoints can't be negative!");
        else if (hp > 0) {
            this.hp -= hp;
            if (this.hp < 0) {
                this.hp = 0;
            }
            System.out.println(getName() + " hit " + " for <" + hp + "> points damage.");
            System.out.println(getName() + " only has " + getHitPoints() + " HP remaining.");
            System.out.println();
        }
        if (this.hp == 0)
            System.out.println(name + " is dead. Sorry bro!");


    }

    public boolean isAlive() {
        return (hp > 0);
    }

    public void attack(DungeonCharacter opponent) {
        boolean canAttack;
        int damage;
        canAttack = Math.random() <= hitProbability;

        if (canAttack == true) {
            damage = (int) (Math.random() * (damageMax - damageMin + 1))
                    + damageMin;
            opponent.subtractHP(damage);
            System.out.println();
        } 
        else {

            System.out.println(getName() + "'s attack on " + opponent.getName() + " was unsuccessful!");
            System.out.println();
        }

    }


}