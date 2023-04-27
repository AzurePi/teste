import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class statBlock {
    private HashMap<abilities, Integer> abilityScores = new HashMap<>();
    private HashMap<abilities, Integer> abilityModifiers = new HashMap<>();
    private HashMap<abilities, Integer> savingThrows = new HashMap<>();
    private HashMap<skills, Integer> skillsModifiers = new HashMap<>();

    private int proficiency;
    private List<skills> skillsProficiencies = new ArrayList<>();
    private List<abilities> savingProficiencies = new ArrayList<>();

    //Constructors -------------------------------------------------------------

    /**
     * Uses the "4d6, drop the lowest" method to determine the ability scores randomly.
     * Assumes +2 proficiency bonus
     */
    public statBlock() {

        for (abilities x : abilities.values())
            abilityScores.put(x, d6Roll());

        proficiency = 2;
        setMods();
    }

    /**
     * Builds the statBlock using the values passed as parameters.
     *
     * @param STR         strength score
     * @param DEX         dexterity score
     * @param CON         constitution score
     * @param INT         intelligence score
     * @param WIS         wisdom score
     * @param CHA         charisma score
     * @param proficiency proficiency bonus
     */
    public statBlock(int STR, int DEX, int CON, int INT, int WIS, int CHA, int proficiency) {
        abilityScores.put(abilities.STRENGHT, STR);
        abilityScores.put(abilities.DEXTERITY, DEX);
        abilityScores.put(abilities.CONSTITUTION, CON);
        abilityScores.put(abilities.INTELLIGENCE, INT);
        abilityScores.put(abilities.WISDOM, WIS);
        abilityScores.put(abilities.CHARISMA, CHA);

        this.proficiency = proficiency;
        setMods();
    }

    //setters & getters
    public HashMap<abilities, Integer> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(HashMap<abilities, Integer> abilityScores) {
        this.abilityScores = abilityScores;
        setMods();
    }

    public HashMap<abilities, Integer> getAbilityModifiers() {
        return abilityModifiers;
    }

    public HashMap<abilities, Integer> getSavingThrows() {
        return savingThrows;
    }

    public HashMap<skills, Integer> getSkillsModifiers() {
        return skillsModifiers;
    }

    public List<skills> getSkillsProficiencies() {
        return skillsProficiencies;
    }

    /**
     * Overrides the previous skill proficiencies of the creature.
     *
     * @param skillsProficiencies the new list of proficiencies
     */
    public void setSkillsProficiencies(List<skills> skillsProficiencies) {
        this.skillsProficiencies = skillsProficiencies;
        setMods();
    }

    public List<abilities> getSavingProficiencies() {
        return savingProficiencies;
    }

    /**
     * Overrides the previous saving throw proficiencies of the creature.
     *
     * @param savingProficiencies the new list of proficiencies
     */
    public void setSavingProficiencies(List<abilities> savingProficiencies) {
        this.savingProficiencies = savingProficiencies;
        setMods();
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
        setMods();
    }

    //Auxiliary methods -------------------------------------------------------

    /**
     * Calculates modifiers for every ability, saving throw and skill using the pre-existing ability scores.
     */
    public void setMods() {
        int mod;

        for (abilities a : abilities.values()) {
            mod = (abilityScores.get(a) - 10) / 2;
            abilityModifiers.put(a, mod);
            savingThrows.put(a, mod); //ignores proficiency
        }

        //strength skill
        mod = abilityModifiers.get(abilities.STRENGHT);
        skillsModifiers.put(skills.ATHLETICS, mod);

        //dexterity skills
        mod = abilityModifiers.get(abilities.DEXTERITY);
        skillsModifiers.put(skills.ACROBATICS, mod);
        skillsModifiers.put(skills.SLEIGHT_OF_HAND, mod);
        skillsModifiers.put(skills.STEALTH, mod);

        //intelligence skills
        mod = abilityModifiers.get(abilities.INTELLIGENCE);
        skillsModifiers.put(skills.ARCANA, mod);
        skillsModifiers.put(skills.HISTORY, mod);
        skillsModifiers.put(skills.INVESTIGATION, mod);
        skillsModifiers.put(skills.NATURE, mod);
        skillsModifiers.put(skills.RELIGION, mod);

        //wisdom skills
        mod = abilityModifiers.get(abilities.WISDOM);
        skillsModifiers.put(skills.ANIMAL_HANDLING, mod);
        skillsModifiers.put(skills.INSIGHT, mod);
        skillsModifiers.put(skills.MEDICINE, mod);
        skillsModifiers.put(skills.PERCEPTION, mod);
        skillsModifiers.put(skills.SURVIVAL, mod);

        //charisma skills
        mod = abilityModifiers.get(abilities.CHARISMA);
        skillsModifiers.put(skills.DECEPTION, mod);
        skillsModifiers.put(skills.INTIMIDATION, mod);
        skillsModifiers.put(skills.PERFORMANCE, mod);
        skillsModifiers.put(skills.PERSUASION, mod);

        //adds skill proficiency bonuses
        for (skills s : skillsProficiencies) {
            mod = skillsModifiers.get(s);
            skillsModifiers.replace(s, mod + proficiency);
        }

        //adds saving throws proficiency bonuses
        for (abilities a : savingProficiencies) {
            int aux = savingThrows.get(a);
            savingThrows.replace(a, mod + proficiency);
        }

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
