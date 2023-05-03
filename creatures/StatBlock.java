import enums.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatBlock {
    private HashMap<Abilities, Integer> abilityScores = new HashMap<>();
    private HashMap<Abilities, Integer> abilityModifiers = new HashMap<>();
    private HashMap<Abilities, Integer> savingThrows = new HashMap<>();
    private HashMap<Skills, Integer> skillsModifiers = new HashMap<>();

    private int proficiency;
    private List<Skills> skillsProficiencies = new ArrayList<>();
    private List<Abilities> savingProficiencies = new ArrayList<>();

    //Constructors -------------------------------------------------------------

    /**
     * Uses the "4d6, drop the lowest" method to determine the ability scores randomly.
     * Assumes +2 proficiency bonus
     */
    public StatBlock() {

        for (Abilities x : Abilities.values())
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
    public StatBlock(int STR, int DEX, int CON, int INT, int WIS, int CHA, int proficiency) {
        abilityScores.put(Abilities.STRENGHT, STR);
        abilityScores.put(Abilities.DEXTERITY, DEX);
        abilityScores.put(Abilities.CONSTITUTION, CON);
        abilityScores.put(Abilities.INTELLIGENCE, INT);
        abilityScores.put(Abilities.WISDOM, WIS);
        abilityScores.put(Abilities.CHARISMA, CHA);

        this.proficiency = proficiency;
        setMods();
    }

    //setters & getters
    public HashMap<Abilities, Integer> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(HashMap<Abilities, Integer> abilityScores) {
        this.abilityScores = abilityScores;
        setMods();
    }

    public HashMap<Abilities, Integer> getAbilityModifiers() {
        return abilityModifiers;
    }

    public HashMap<Abilities, Integer> getSavingThrows() {
        return savingThrows;
    }

    public HashMap<Skills, Integer> getSkillsModifiers() {
        return skillsModifiers;
    }

    public List<Skills> getSkillsProficiencies() {
        return skillsProficiencies;
    }

    /**
     * Overrides the previous skill proficiencies of the creature.
     *
     * @param skillsProficiencies the new list of proficiencies
     */
    public void setSkillsProficiencies(List<Skills> skillsProficiencies) {
        this.skillsProficiencies = skillsProficiencies;
        setMods();
    }

    public List<Abilities> getSavingProficiencies() {
        return savingProficiencies;
    }

    /**
     * Overrides the previous saving throw proficiencies of the creature.
     *
     * @param savingProficiencies the new list of proficiencies
     */
    public void setSavingProficiencies(List<Abilities> savingProficiencies) {
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

        for (Abilities a : Abilities.values()) {
            mod = (abilityScores.get(a) - 10) / 2;
            abilityModifiers.put(a, mod);
            savingThrows.put(a, mod); //ignores proficiency
        }

        //strength skill
        mod = abilityModifiers.get(Abilities.STRENGHT);
        skillsModifiers.put(Skills.ATHLETICS, mod);

        //dexterity enums.skills
        mod = abilityModifiers.get(Abilities.DEXTERITY);
        skillsModifiers.put(Skills.ACROBATICS, mod);
        skillsModifiers.put(Skills.SLEIGHT_OF_HAND, mod);
        skillsModifiers.put(Skills.STEALTH, mod);

        //intelligence enums.skills
        mod = abilityModifiers.get(Abilities.INTELLIGENCE);
        skillsModifiers.put(Skills.ARCANA, mod);
        skillsModifiers.put(Skills.HISTORY, mod);
        skillsModifiers.put(Skills.INVESTIGATION, mod);
        skillsModifiers.put(Skills.NATURE, mod);
        skillsModifiers.put(Skills.RELIGION, mod);

        //wisdom enums.skills
        mod = abilityModifiers.get(Abilities.WISDOM);
        skillsModifiers.put(Skills.ANIMAL_HANDLING, mod);
        skillsModifiers.put(Skills.INSIGHT, mod);
        skillsModifiers.put(Skills.MEDICINE, mod);
        skillsModifiers.put(Skills.PERCEPTION, mod);
        skillsModifiers.put(Skills.SURVIVAL, mod);

        //charisma enums.skills
        mod = abilityModifiers.get(Abilities.CHARISMA);
        skillsModifiers.put(Skills.DECEPTION, mod);
        skillsModifiers.put(Skills.INTIMIDATION, mod);
        skillsModifiers.put(Skills.PERFORMANCE, mod);
        skillsModifiers.put(Skills.PERSUASION, mod);

        //adds skill proficiency bonuses
        for (Skills s : skillsProficiencies) {
            mod = skillsModifiers.get(s);
            skillsModifiers.replace(s, mod + proficiency);
        }

        //adds saving throws proficiency bonuses
        for (Abilities a : savingProficiencies) {
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

        for (int i = 0; i < 4; i++)
            aux.add(Dice.d6());

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
