package enums;

public enum Sense {
    /**
     * A creature with BLINDSIGHT can perceive its surroundings without relying on sight, within a specific radius.
     */
    BLINDSIGHT,
    /**
     * A cresture with darkvision can see in the dark within a specific radius. The creature can see in dim light within the radius as if it were bright light, and in darkness as if it were dim light. The creature can't discern color in darkness, only shades of gray.
     */
    DARKVISION,
    /**
     * A creature with tremorsense can detect and pinpoint the origin of vibrations within a specific radius, provided that the creature and the source of the vibrations are in contact with the same ground or substance.
     * Tremorsense can't be used to detect flying or incorporeal creatures.
     */
    TREMORSENSE,
    /**
     * A creature with truesight can, out to a specific range, see in normal and magical darkness, see invisible creatures and objects, automatically detect visual illusions and succeed on saving throws against them, and perceive the original form of a shapechanger or a creature that is transformed by magic. Furthermore, the creature can see into the Ethereal Plane within the same range.
     */
    TRUESIGHT
}
