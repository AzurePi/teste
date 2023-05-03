import enums.*;

import java.util.*;

public class Creature extends StatBlock {
    String name;
    private Size creatureSize;
    private Type creatureType;
    private ArrayList<Tag> creatureTags = new ArrayList<>();
    private List<Object> alignment = Arrays.asList(new Object[2]); //list with fixed enums.size of 2
    private Map<Sense, Integer> senses;
    private String description;
    private double challengeRating;

    private int hitPointTotal;
    private int speed;
    private int armorClass;

    public Creature() {
        System.out.println("----- New Creature -----");

        Scanner sc = new Scanner(System.in);
        int x;

        System.out.print("Name: ");
        name = sc.nextLine();

        System.out.println("Size");
        System.out.println("1 - TINY\t2 - SMALL\t3 - MEDIUM\t4 - LARGE\t5 - HUGE\t6 - GARGANTUAN");
        x = sc.nextInt();
        switch (x) {
            case 1 -> this.creatureSize = Size.TINY;
            case 2 -> this.creatureSize = Size.SMALL;
            case 3 -> this.creatureSize = Size.MEDIUM;
            case 4 -> this.creatureSize = Size.LARGE;
            case 5 -> this.creatureSize = Size.HUGE;
            case 6 -> this.creatureSize = Size.GARGANTUAN;
        }

        System.out.println("Creature Type");
        System.out.println("1 - ABERRATION\t2 - BEAST\t3 - CELESTIAL\t4 - CONSTRUCT\t5 - DRAGON");
        System.out.println("6 - ELEMENTAL\t7 - FEY\t8 - FIEND\t9 - GIANT\t10 - HUMANOID");
        System.out.println("11 - MONSTROSITY\t12 - OOZE\t13 - PLANT\t14 - UNDEAD");






    }


}
