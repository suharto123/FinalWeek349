
public class CrushingBlow extends SecondaryMove {
	@Override
    public void useSkill(DungeonCharacter opponent,Hero hero) {

        if (Math.random() <= .4)
        {
            int attackPoints = (int)(Math.random() * 76) + 100;
            System.out.println(hero.getName() + " lands a CRUSHING BLOW for " + attackPoints + " damage on " +  opponent.getName());
            opponent.subtractHP(attackPoints);
        }
        else {
            System.out.println(hero.getName() + " failed to land a crushing blow on " + opponent.getName());
            System.out.println();
        }
	}
}
