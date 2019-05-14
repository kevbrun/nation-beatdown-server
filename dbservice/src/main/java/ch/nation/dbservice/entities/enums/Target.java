package ch.nation.dbservice.entities.enums;

public enum  Target {
    SELF("Self"),PARTY_ALL("PartyAll"),ENEMY_ALL("EnemyAll"),PARTY_SINGLE("PartySingle"),ENEMY_SINGLE("Enemy_Single"),
    ANY_SINGLE("AnySingle"),ANY_ALL("AnyAll");

    private String value;


    Target(String value) {
        this.value = value;
    }
}
