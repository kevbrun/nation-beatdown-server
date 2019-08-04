package ch.nation.core.model.Enums;


import ch.nation.core.utils.EnumUtilties;

public enum StatGrowthType implements IEnumFromValue<StatGrowthType> {
    NONE("None"),LINEAR("Linear"),LOGARITHMIC("Logarithmic"),EXPONENTIAL("Exponential");

     private String str;

    StatGrowthType(String type) {
        this.str = type;
    }


    public StatGrowthType fromValue(String value) {
        return EnumUtilties.getEnumFromString(StatGrowthType.class,value);
    }


    public String toJson() {
        return str;
    }
}
