import java.util.ArrayList;
import java.util.HashMap;

public class statBlock {
    public HashMap<stats, Integer> abilityScores = new HashMap<>();
    public HashMap<stats, Integer> abilityModifiers = new HashMap<>();
    public HashMap<stats, Integer> savingThrows = new HashMap<>();
    public HashMap<skills, Integer> skillsModifiers = new HashMap<>();

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

        for(stats x : stats.values())
            abilityScores.put(x, d6Roll());

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
     * @param CHA charisma score
     */
    public statBlock(int STR, int DEX, int CON, int INT, int WIS, int CHA) {
        abilityScores.put(stats.STRENGHT, STR);
        abilityScores.put(stats.DEXTERITY, DEX);
        abilityScores.put(stats.CONSTITUTION, CON);
        abilityScores.put(stats.INTELLIGENCE, INT);
        abilityScores.put(stats.WISDOM, WIS);
        abilityScores.put(stats.CHARISMA, CHA);

        setMods();
    }


    //Auxiliary methods ------------------------------------------------

    /**
     * Calculates modifiers for every ability, saving throw and skill using the pre-existing ability scores.
     * Doesn't take proficiency into account.
     */
    public void setMods() {
        int mod;

        for(stats x : stats.values()){
            mod = (abilityScores.get(x) - 10) / 2;
            abilityModifiers.put(x, mod);
            savingThrows.put(x, mod); //ignores proficiency
        }

        //strength skill
        mod = abilityModifiers.get(stats.STRENGHT);
        skillsModifiers.put(skills.ATHLETICS, mod);

        //dexterity skills
        mod = abilityModifiers.get(stats.DEXTERITY);
        skillsModifiers.put(skills.ACROBATICS, mod);
        skillsModifiers.put(skills.SLEIGHT_OF_HAND, mod);
        skillsModifiers.put(skills.STEALTH, mod);

        //intelligence skills
        mod = abilityModifiers.get(stats.INTELLIGENCE);
        skillsModifiers.put(skills.ARCANA, mod);
        skillsModifiers.put(skills.HISTORY, mod);
        skillsModifiers.put(skills.INVESTIGATION, mod);
        skillsModifiers.put(skills.NATURE, mod);
        skillsModifiers.put(skills.RELIGION, mod);

        //wisdom skills
        mod = abilityModifiers.get(stats.WISDOM);
        skillsModifiers.put(skills.ANIMAL_HANDLING, mod);
        skillsModifiers.put(skills.INSIGHT, mod);
        skillsModifiers.put(skills.MEDICINE, mod);
        skillsModifiers.put(skills.PERCEPTION, mod);
        skillsModifiers.put(skills.SURVIVAL, mod);

        //charisma skills
        mod = abilityModifiers.get(stats.CHARISMA);
        skillsModifiers.put(skills.DECEPTION, mod);
        skillsModifiers.put(skills.INTIMIDATION, mod);
        skillsModifiers.put(skills.PERFORMANCE, mod);
        skillsModifiers.put(skills.PERSUASION, mod);
    }

    /**
     * Uses the method of "roll 4d6, drop the lowest" to determine a score
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
