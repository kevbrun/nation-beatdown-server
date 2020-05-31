package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum WeaponType implements IEnumFromValue<WeaponType> {
    MELEE1H("Melee1H"),
    MELEE2H("Melee2H"),
    MELEEPAIRED("MeleePaired"),
    BOW("Bow"),
    FIREARMS1H("Firearms1H"),
    FIREARMS2H("Firearms2H"),
    FIREARMSPAIRED("FirearmsPaired"),
    SUPPLIES("Supplies");

    private String str;

    WeaponType(String str) {
        this.str = str;
    }

    @Override
    public WeaponType fromValue(String value) {
        return EnumUtilties.getEnumFromString(WeaponType.class, value);
    }

    @Override
    public String toJson() {
        return str;
    }
}
