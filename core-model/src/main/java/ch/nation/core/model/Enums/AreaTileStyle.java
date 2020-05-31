package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum AreaTileStyle implements IEnumFromValue<AreaTileStyle> {
    NONE("None"), ATTACK_AXE("AtkAxe"), WALK("Walk"), POSITIVE_HEAL("PosHeal");


    private String value;

    AreaTileStyle(String value) {
        this.value = value;
    }

    @Override
    public AreaTileStyle fromValue(String value) {
        return EnumUtilties.getEnumFromString(AreaTileStyle.class, value);
    }

    @Override
    public String toJson() {
        return value;
    }
}
