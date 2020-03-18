import java.util.Random;

public enum MonsterFactory {
    OGRE,
    SKELETON,
    GREMLIN;

    private static Random random = new Random();

    public Monster make(){
        switch(this){
            case OGRE:
                return new Ogre();
            case SKELETON:
                return new Skeleton();
            case GREMLIN:
                return new Gremlin();
        }

        return rand();
    }

    public static Monster rand(){
    	MonsterFactory[] mon = MonsterFactory.values();
        return mon[random.nextInt(mon.length)].make();
    }

}