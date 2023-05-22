import enums.*;
import exceptions.InvalidAlignmentException;
import exceptions.InvalidCreatureSizeException;
import exceptions.InvalidCreatureTypeException;
import exceptions.InvalidSenseException;

import java.util.HashMap;
import java.util.Scanner;

public class Creature extends StatBlock {
    String name;
    private Size creatureSize = null;
    private Type creatureType = null;
    private Alignement alignment = new Alignement();
    private HashMap<Sense, Integer> senses = new HashMap<>();
    private String description;
    private double challengeRating;
    private int hitPointTotal;
    private int speed;
    private int armorClass;

    private HashMap<Condition, Boolean> conditions = new HashMap<>();
    private short exhaustion;

    //Constructor -------------------------------------------------------------------------

    public Creature() {
        System.out.println("----- New Creature -----");

        Scanner sc = new Scanner(System.in);
        int flag = 0;

        System.out.print("Name: ");
        setName(sc.nextLine());

        try {
            setCreatureSize();
        } catch (InvalidCreatureSizeException e) {
            System.out.println("ERROR: " + e.getMessage());
            flag++;
        }

        try {
            setCreatureType();
        } catch (InvalidCreatureTypeException e) {
            System.out.println("ERROR: " + e.getMessage());
            flag++;
        }

        try {
            setAlignment();
        } catch (InvalidAlignmentException e) {
            System.out.println("ERROR: " + e.getMessage());
            flag++;
        }

        try {
            setSenses();
        } catch (InvalidSenseException e) {
            System.out.println("ERROR: " + e.getMessage());
            flag++;
        }

        System.out.println("Description");
        setDescription(sc.nextLine());

        if (!(this instanceof Character)) {
            System.out.print("Challenge rating: ");
            setChallengeRating(sc.nextInt());

            System.out.print("Hit point total: ");
            setHitPointTotal(sc.nextInt());

            System.out.print("Armor class: ");
            setArmorClass(sc.nextInt());
        }

        for (Condition c : Condition.values())
            conditions.put(c, false);
        exhaustion = 0;

        if (flag > 0)
            System.out.println(flag + "ERRORS detected.");
    }

    //Setters & Getters -------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getCreatureSize() {
        return creatureSize;
    }

    public void setCreatureSize(Size creatureSize) {
        this.creatureSize = creatureSize;
    }

    public void setCreatureSize() throws InvalidCreatureSizeException {
        int x;
        Scanner sc = new Scanner(System.in);

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
            default -> throw new InvalidCreatureSizeException();
        }
    }

    public Type getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(Type creatureType) {
        this.creatureType = creatureType;
    }

    public void setCreatureType() throws InvalidCreatureTypeException {
        int x;
        Scanner sc = new Scanner(System.in);

        System.out.println("Creature Type");
        System.out.println("1 - ABERRATION\t2 - BEAST\t3 - CELESTIAL\t4 - CONSTRUCT\t5 - DRAGON");
        System.out.println("6 - ELEMENTAL\t7 - FEY\t8 - FIEND\t9 - GIANT\t10 - HUMANOID");
        System.out.println("11 - MONSTROSITY\t12 - OOZE\t13 - PLANT\t14 - UNDEAD");
        x = sc.nextInt();
        switch (x) {
            case 1 -> this.creatureType = Type.ABERRATION;
            case 2 -> this.creatureType = Type.BEAST;
            case 3 -> this.creatureType = Type.CELESTIAL;
            case 4 -> this.creatureType = Type.CONSTRUCT;
            case 5 -> this.creatureType = Type.DRAGON;
            case 6 -> this.creatureType = Type.ELEMENTAL;
            case 7 -> this.creatureType = Type.FEY;
            case 8 -> this.creatureType = Type.FIEND;
            case 9 -> this.creatureType = Type.GIANT;
            case 10 -> this.creatureType = Type.HUMANOID;
            case 11 -> this.creatureType = Type.MONSTROSITY;
            case 12 -> this.creatureType = Type.OOZE;
            case 13 -> this.creatureType = Type.PLANT;
            case 14 -> this.creatureType = Type.UNDEAD;
            default -> throw new InvalidCreatureTypeException();
        }
    }

    public Alignement getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignement alignment) {
        this.alignment = alignment;
    }

    public void setAlignent(Alignment1 a1, Alignment2 a2) {
        this.alignment.al1 = a1;
        this.alignment.al2 = a2;
    }

    public void setAlignment() throws InvalidAlignmentException {
        int x, y;
        Scanner sc = new Scanner(System.in);

        System.out.println("Alignment");
        System.out.println("1 - LAWFUL\t2 - NEUTRAL\t3 - CHAOTIC");
        System.out.println("1 - GOOD\t2 - NEUTRAL\t3 - EVIL");

        x = sc.nextInt();
        y = sc.nextInt();
        switch (x) {
            case 1 -> alignment.al1 = Alignment1.LAWFUL;
            case 2 -> alignment.al1 = Alignment1.NEUTRAL;
            case 3 -> alignment.al1 = Alignment1.CHAOTIC;
            default -> throw new InvalidAlignmentException();
        }
        switch (y) {
            case 1 -> alignment.al2 = Alignment2.GOOD;
            case 2 -> alignment.al2 = Alignment2.NEUTRAL;
            case 3 -> alignment.al2 = Alignment2.EVIL;
            default -> throw new InvalidAlignmentException();
        }
    }

    public HashMap<Sense, Integer> getSenses() {
        return senses;
    }

    public void setSenses(HashMap<Sense, Integer> senses) {
        this.senses = senses;
    }

    public void setSenses() throws InvalidSenseException {
        int x;
        Scanner sc = new Scanner(System.in);

        System.out.println("Toggle Senses");
        System.out.println("1 - BLINDSIGHT\t2 - DARKVISION\t3 - TREMORSENSE\t4 - TRUESIGHTC");
        System.out.println("0 - done");

        do {
            x = sc.nextInt();
            switch (x) {
                case 1 -> toggleSense(Sense.BLINDSIGHT);
                case 2 -> toggleSense(Sense.DARKVISION);
                case 3 -> toggleSense(Sense.TREMORSENSE);
                case 4 -> toggleSense(Sense.TRUESIGHT);
                case 0 -> {}
                default -> throw new InvalidSenseException();
            }
        } while (x != 0);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getChallengeRating() {
        return challengeRating;
    }

    public void setChallengeRating(double challengeRating) {
        this.challengeRating = challengeRating;
    }

    public int getHitPointTotal() {
        return hitPointTotal;
    }

    public void setHitPointTotal(int hitPointTotal) {
        this.hitPointTotal = hitPointTotal;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }


    public void toggleSense(Sense s) {
        if (senses.containsKey(s)) {
            senses.remove(s);
            System.out.println(s + " removed");
        } else {
            Scanner sc = new Scanner(System.in);
            int x;

            System.out.print("Range: ");
            x = sc.nextInt();
            senses.put(s, x);
            System.out.println(s + " added with range of " + x);
        }
    }
}
