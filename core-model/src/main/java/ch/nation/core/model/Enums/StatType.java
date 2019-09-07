package ch.nation.core.model.Enums;


import ch.nation.core.utils.EnumUtilties;

public enum  StatType  implements IEnumFromValue<StatType>{
    NONE("None"),HEALTH_POINTS("HealthPoints"),ACTION_POINTS("ActionPoints"),
        VITALITY("Vitality"),INTELIGENCE("Intelligence"),DEXTERITY("Dexterity"),AGILITY("Agility"),STRENGTH("Strength");

    private String str;

    StatType(String str) {
        this.str = str;
    }

    public StatType fromValue(String value) {
        return EnumUtilties.getEnumFromString(StatType.class,value);

    }


    public String toJson() {
        return str;
    }
}
