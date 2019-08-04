package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum StatModTarget implements IEnumFromValue<StatModTarget> {
    MIN_VALUE("MinValue"),MAX_VALUE("MaxValue"),VALUE("Value"),ALL("ALL");

    private String str;

    private StatModTarget(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "StatModTarget{" +
                "str='" + str + '\'' +
                "} " + super.toString();
    }

    @Override
    public StatModTarget fromValue(String value) {
        return EnumUtilties.getEnumFromString(StatModTarget.class,value);
    }

    @Override
    public String toJson() {
        return str;
    }
}
