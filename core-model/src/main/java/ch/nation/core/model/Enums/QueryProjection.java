package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum QueryProjection implements IEnumFromValue<QueryProjection> {
    min("min"),
    def("default"),
    max("max"),
    max_nested_uuid("max_nested_uuid"),
    newgame("newgame");

    private String str;

    private QueryProjection(String str) {
        this.str = str;
    }

    @Override
    public QueryProjection fromValue(String value) {
        return EnumUtilties.getEnumFromString(QueryProjection.class, value);

    }

    @Override
    public String toJson() {
        return str;
    }
}
