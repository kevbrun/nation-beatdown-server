package ch.nation.core.model.Enums;


import ch.nation.core.utils.EnumUtilties;

public enum  Target implements IEnumFromValue<Target>{
    SELF("Self"),PARTY_ALL("PartyAll"),ENEMY_ALL("EnemyAll"),PARTY_SINGLE("PartySingle"),ENEMY_SINGLE("EnemySingle"),
    ANY_SINGLE("AnySingle"),ANY_ALL("AnyAll"),AREA_ALL("AreaAll"),AREA_ENEMY("AreaEnemy"),AREA_PARTY("AreaParty"),NONE("None");

    private String str;


     private Target(String value) {
        this.str = value;
    }


    public Target fromValue(String value) {
        return EnumUtilties.getEnumFromString(Target.class,value);
    }


    public String toJson() {
        return str;
    }
}
