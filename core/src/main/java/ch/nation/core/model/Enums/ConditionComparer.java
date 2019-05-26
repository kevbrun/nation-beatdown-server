package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum ConditionComparer implements IEnumFromValue<ConditionComparer> {
    EQUALS("Equals"),SMALLER_THAN("SmallerThan"),BIGGER_THAN("BiggerThan");

    private String str;

    ConditionComparer(String str) {
        this.str = str;
    }


    @Override
    public ConditionComparer fromValue(String value) {
        return EnumUtilties.getEnumFromString(this.getDeclaringClass(),value);
    }

    @Override
    public String toJson() {
        return str;
    }
}

