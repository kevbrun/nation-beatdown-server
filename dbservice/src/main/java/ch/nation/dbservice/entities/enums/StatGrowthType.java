package ch.nation.dbservice.entities.enums;

import ch.nation.dbservice.utils.EnumUtilties;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
