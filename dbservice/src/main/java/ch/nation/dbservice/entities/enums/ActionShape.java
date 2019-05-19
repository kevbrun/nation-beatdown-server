package ch.nation.dbservice.entities.enums;

import ch.nation.dbservice.utils.EnumUtilties;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
