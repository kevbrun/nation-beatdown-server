package ch.nation.dbservice.entities.enums;

public enum  ActionShape {
    FILLED_BLOCK("FilledBlock"),CIRCLE("Circle"),CROSS("Cross"),FILLED_CIRCLE("FilledCircle"),NONE("None");

    private String value;

    ActionShape(String value) {
        this.value = value;
    }
}
