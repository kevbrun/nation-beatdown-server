package ch.nation.dbservice.entities.Enums;

import ch.nation.dbservice.utils.EnumUtilties;

public enum  ActionShape implements IEnumFromValue<ActionShape>{
    FILLED_BLOCK("FilledBlock"),CIRCLE("Circle"),CROSS("Cross"),FILLED_CIRCLE("FilledCircle"),NONE("None");

    private String str;

    ActionShape(String value) {
        this.str = value;
    }


    public ActionShape fromValue(String value) {
        return EnumUtilties.getEnumFromString(ActionShape.class,value);
    }


    public String toJson() {
        return str;
    }
}
