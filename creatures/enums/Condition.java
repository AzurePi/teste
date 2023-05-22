package enums;

/**
 * Conditions alter a creature's capabilities in a variety of ways and can arise as a result of a spell, a class feature, a monster's attack, or other effect.
 * <p>
 * A condition lasts either until it is countered or for a duration specified by the effect that imposed the condition.
 * <p>
 * If multiple effects impose the same condition on a creature, each instance of the condition has its own duration, but the condition's effects don't get worse. A creature either has a condition or doesn't.
 */
public enum Condition {
    /**
     * BLINDED: A BLINDED creature can't see and automatically fails any ability check that requires sight. Attack rolls against the creature have advantage, and the creature's attack rolls have disadvantage.
     */
    BLINDED,
    /**
     * CHARMED: A CHARMED creature can't attack the charmer or target the charmer with harmful abilities or magical effects. The charmer has advantage on any ability check to interact socially with the creature.
     */
    CHARMED,
    /**
     * DEAFENED: A DEAFENED creature can't hear and automatically fails any ability check that requires hearing.
     */
    DEAFENED,
    /**
     * FRIGHTENED: A FRIGHTENED creature has disadvantage on ability checks and attack rolls while the source of its fear is within line of sight. The creature can't willingly move closer to the source of its fear.
     */
    FRIGHTENED,
    /**
     * GRAPPLED: A GRAPPLED creature's speed becomes 0, and it can't benefit from any bonus to its speed. The condition ends if the grappler is INCAPACITATED. The condition also ends if an effect removes the grappled creature from the reach of the grappler or grappling effect, such as when a creature is hurled away by the thunderwave spell.
     */
    GRAPPLED,
    /**
     * INCAPACITATED: An INCAPACITATED creature can't take actions or reactions.
     */
    INCAPACITATED,
    /**
     * INVISIBLE: An INVISIBLE creature is impossible to see without the aid of magic or a special sense. For the purpose of hiding, the creature is heavily obscured. The creature's location can be detected by any noise it makes or any tracks it leaves. Attack rolls against the creature have disadvantage, and the creature's attack rolls have advantage.
     */
    INVISIBLE,
    /**
     * PARALYZED: A PARALYZED creature is INCAPACITATED and can't move or speak. The creature automatically fails Strength and Dexterity saving throws. Attack rolls against the creature have advantage. Any attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature.
     */
    PARALYZED,
    /**
     * PETRIFIED: A PETRIFIED creature is transformed, along with any nonmagical object it is wearing or carrying, into a solid inanimate substance (usually stone). Its weight increases by a factor of ten, and it ceases aging. The creature is INCAPACITATED, can't move or speak, and is unaware of its surroundings. Attack rolls against the creature have advantage. The creature automatically fails Strength and Dexterity saving throws. The creature has resistance to all damage. The creature is immune to poison and disease, although a poison or disease already in its system is suspended, not neutralized.
     */
    PETRIFIED,
    /**
     * POISONED: A POISONED creature has disadvantage on attack rolls and ability checks.
     */
    POISONED,
    /**
     * PRONE: A PRONE creature's only movement option is to crawl, unless it stands up and thereby ends the condition. The creature has disadvantage on attack rolls. An attack roll against the creature has advantage if the attacker is within 5 feet of the creature. Otherwise, the attack roll has disadvantage.
     */
    PRONE,
    /**
     * RESTRAINED: A RESTRAINED creature's speed becomes 0, and it can't benefit from any bonus to its speed. Attack rolls against the creature have advantage, and the creature's attack rolls have disadvantage. The creature has disadvantage on Dexterity saving throws.
     */
    RESTRAINED,
    /**
     * STUNNED: A STUNNED creature is INCAPACITATED, can't move, and can speak only falteringly. The creature automatically fails Strength and Dexterity saving throws. Attack rolls against the creature have advantage.
     */
    STUNNED,
    /**
     * UNCONSCIOUS: An UNCONSCIOUS creature is INCAPACITATED, can't move or speak, and is unaware of its surroundings. The creature drops whatever it's holding and falls PRONE. The creature automatically fails Strength and Dexterity saving throws. Attack rolls against the creature have advantage. Any attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature.
     */
    UNCONSCIOUS
}
