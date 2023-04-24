import java.util.ArrayList;

public class statBlock {
    //Abilities --------------------------------------------------------
    public int strength;
    public int strMod;
    public int dexterity;
    public int dexMod;
    public int constitution;
    public int conMod;
    public int intelligence;
    public int intMod;
    public int wisdom;
    public int wisMod;
    public int charisma;
    public int chaMod;

    //Saving throws -----------------------------------------------------
    public int strSave;
    public int dexSave;
    public int conSave;
    public int intSave;
    public int wisSave;
    public int chaSave;

    //Skill modifiers ---------------------------------------------------
    public int athletics;
    public int acrobatics;
    public int sleightOfHand;
    public int stealth;
    public int arcana;
    public int history;
    public int investigation;
    public int nature;
    public int religion;
    public int animalHandling;
    public int insight;
    public int medicine;
    public int perception;
    public int survival;
    public int deception;
    public int intimidation;
    public int performance;
    public int persuasion;

    //Constructors ------------------------------------------------------

    /**
     * Uses the "4d6, drop the lowest" method to determine the ability scores randomly.
     */
    public statBlock() {
        strength = d6Roll();
        dexterity = d6Roll();
        constitution = d6Roll();
        intelligence = d6Roll();
        wisdom = d6Roll();
        charisma = d6Roll();

        setMods();
    }

    /**
     * Builds the statBlock using the values passed as parameters
     *
     * @param STR strength score
     * @param DEX dexterity score
     * @param CON constitution score
     * @param INT intelligence score
     * @param WIS wisdom score
     * @param CHA charsma score
     */
    public statBlock(int STR, int DEX, int CON, int INT, int WIS, int CHA) {
        this.strength = STR;
        this.dexterity = DEX;
        this.constitution = CON;
        this.intelligence = INT;
        this.wisdom = WIS;
        this.charisma = CHA;

        setMods();
    }


    //Auxiliary methods ------------------------------------------------

    /**
     * Calculates de modifiers for every ability, saving throw and skill using the pre-existing ability scores.
     * Doesn't take proficiency into account.
     */
    public void setMods() {
        strMod = (strength - 10) / 2;
        dexMod = (dexterity - 10) / 2;
        conMod = (constitution - 10) / 2;
        intMod = (intelligence - 10) / 2;
        wisMod = (wisdom - 10) / 2;
        chaMod = (charisma - 10) / 2;

        //saving throw modifiers
        strSave = strMod;
        dexSave = dexMod;
        conSave = conMod;
        intSave = intMod;
        wisSave = wisMod;
        chaSave = chaMod;

        //strength skill
        athletics = strMod;

        //dexterity skills
        acrobatics = dexMod;
        sleightOfHand = dexMod;
        stealth = dexMod;

        //intelligence skills
        arcana = intMod;
        history = intMod;
        investigation = intMod;
        nature = intMod;
        religion = intMod;

        //wisdom skills
        animalHandling = wisMod;
        insight = wisMod;
        medicine = wisMod;
        perception = wisMod;
        survival = wisMod;

        //charisma skills
        deception = chaMod;
        intimidation = chaMod;
        performance = chaMod;
        persuasion = chaMod;
    }

    /**
     * Uses the method of "roll 4d6, drop the lowest" to determine ability scores
     *
     * @return an int in the range of 3 to 18
     */
    private int d6Roll() {
        ArrayList<Integer> aux = null;
        int stat = 0;

        for (int i = 0; i < 4; i++) {
            aux.add(dice.d6());
        }

        int menor = 6;
        for (int x : aux) {
            if (x <= menor)
                menor = x;
        }
        aux.remove(menor);

        for (int x : aux)
            stat += x;

        return stat;
    }

}
