package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum PrejudiceOperator implements IEnumFromValue<PrejudiceOperator> {
    NONE("None"), AND("And"), OR("Or");

    private String str;

    PrejudiceOperator(String str) {
        this.str = str;
    }

    @Override
    public PrejudiceOperator fromValue(String value) {
        return EnumUtilties.getEnumFromString(PrejudiceOperator.class, value);
    }

    @Override
    public String toJson() {
        return str;
    }
}
