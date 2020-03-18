
public class SurpriseAttack extends SecondaryMove {
	@Override
    public void useSkill(DungeonCharacter opponent, Hero hero) {
        int hPoints;
        hPoints = (int)(Math.random() * (50 - 25 + 1)) + 25;
        hero.setHitPoints(hPoints);
        System.out.println(hero.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + hero.getHitPoints());
        System.out.println();

    }
}
