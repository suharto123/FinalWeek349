
public abstract class Monster extends DungeonCharacter
{
	private double chanceToHeal;
	private int minHeal;
	private int maxHeal;

  public Monster(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin, int damageMax, int minHeal, int maxHeal) {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	setChanceToHeal(chanceToHeal);
	setMinHeal(minHeal);
	setMaxHeal(maxHeal);

  }



	public void setChanceToHeal(double chanceToHeal) {
		this.chanceToHeal = chanceToHeal;
	}



	public void setMinHeal(int minHeal) {
		this.minHeal = minHeal;
	}



	public void setMaxHeal(int maxHeal) {
		this.maxHeal = maxHeal;
	}

	public void heal() {
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= chanceToHeal) && (getHitPoints() > 0);

		if (canHeal) {
			healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			setHitPoints(healPoints);
			System.out.println(getName() + " recovered " + healPoints + " points.\n" + "Total HP remaining are: " + getHitPoints());
		System.out.println();
		}
	}


 public void subtractHitPoints(int hitPoints) {
		super.subtractHP(hitPoints);
		heal();

 }


}