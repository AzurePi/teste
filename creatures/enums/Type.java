package enums;

/**
 * A creature's type speaks to its fundamental nature. Certain spells, magic items, class features, and other effects in the game interact in special ways with creatures of a particular type.
 */
public enum Type {
    /**
     * Aberrations are utterly alien beings. Many of them have innate magical abilities drawn from the creature's alien mind rather than the mystical forces of the world.
     */
    ABERRATION,
    /**
     * Beasts are nonhumanoid creatures that are a natural part of the fantasy ecology. Some of them have magical powers, but most are unintelligent and lack any society or language. Beasts include all varieties of ordinary animals, dinosaurs, and giant versions of animals.
     */
    BEAST,
    /**
     * Celestials are creatures native to the Upper Planes. Many of them are the servants of deities, employed as messengers or agents in the mortal realm and throughout the planes. Celestials are good by nature, so the exceptional celestial who strays from a good alignment is a horrifying rarity.
     */
    CELESTIAL,
    /**
     * Constructs are made, not born. Some are programmed by their creators to follow a simple set of instructions, while others are imbued with sentience and capable of independent thought. Golems are the iconic constructs. Many creatures native to the outer plane of Mechanus, such as modrons, are constructs shaped from the raw material of the plane by the will of more powerful creatures.
     */
    CONSTRUCT,
    /**
     * Dragons are large reptilian creatures of ancient origin and tremendous power. True dragons, including the good metallic dragons and the evil chromatic dragons, are highly intelligent and have innate magic. Also in this category are creatures distantly related to true dragons, but less powerful, less intelligent, and less magical, such as wyverns and pseudodragons.
     */
    DRAGON,
    /**
     * Elementals are creatures native to the elemental planes. Some creatures of this type are little more than animate masses of their respective elements, including the creatures simply called elementals. Others have biological forms infused with elemental energy.
     */
    ELEMENTAL,
    /**
     * Fey are magical creatures closely tied to the forces of nature. They dwell in twilight groves and misty forests. In some worlds, they are closely tied to the Feywild, also called the Plane of Faerie. Some are also found in the Outer Planes, particularly the planes of Arborea and the Beastlands.
     */
    FEY,
    /**
     * Fiends are creatures of wickedness that are native to the Lower Planes. A few are the servants of deities, but many more labor under the leadership of archdevils and demon princes. Evil priests and mages sometimes summon fiends to the material world to do their bidding. If an evil celestial is a rarity, a good fiend is almost inconceivable.
     */
    FIEND,
    /**
     * Giants tower over humans and their kind. They are humanlike in shape, though some have multiple heads or deformities.
     */
    GIANT,
    /**
     * Giants tower over humans and their kind. They are humanlike in shape, though some have multiple heads (ettins) or deformities (fomorians).
     */
    HUMANOID,
    /**
     * Monstrosities are monsters in the strictest sense--frightening creatures that are not ordinary, not truly natural, and almost never benign. Some are the results of magical experimentation gone awry, and others are the product of terrible curses. They defy categorization, and in some sense serve as a catch-all category for creatures that don't fit into any other type.
     */
    MONSTROSITY,
    /**
     * Oozes are gelatinous creatures that rarely have a fixed shape. They are mostly subterranean, dwelling in caves and dungeons and feeding on refuse, carrion, or creatures unlucky enough to get in their way.
     */
    OOZE,
    /**
     * Plants in this context are vegetable creatures, not ordinary flora. Most of them are ambulatory, and some are carnivorous. Fungal creatures also fall into this category.
     */
    PLANT,
    /**
     * Undead are once-living creatures brought to a horrifying state of undeath through the practice of necromantic magic or some unholy curse.
     */
    UNDEAD
}

