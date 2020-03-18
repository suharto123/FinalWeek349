import java.util.Random;

public enum HeroFactory{
    THIEF,
    WARRIOR,
    SORCERESS;

    private static Random random = new Random();

    public Hero make(){
        switch(this){

            case THIEF:
                return new Thief();
            case WARRIOR:
                return new Warrior();
            case SORCERESS:
                return new Sorceress();

        }

        return rand();
    }

    public static Hero rand(){
        HeroFactory[] heros = HeroFactory.values();
        return heros[ random.nextInt( heros.length ) ].make();
    }

}

