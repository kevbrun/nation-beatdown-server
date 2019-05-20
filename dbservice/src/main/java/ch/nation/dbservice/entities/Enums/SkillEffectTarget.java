package ch.nation.dbservice.entities.Enums;

import ch.nation.dbservice.utils.EnumUtilties;

public enum SkillEffectTarget implements IEnumFromValue<SkillEffectTarget> {
    NONE("None"),CASTER("Caster"),TARGET("Target"),RANDOM_TARGET("Random_Target");

    private String str;

    SkillEffectTarget(String str) {
        this.str = str;
    }


    public SkillEffectTarget fromValue(String value) {
        return  EnumUtilties.getEnumFromString(SkillEffectTarget.class,value);
    }


    public String toJson() {
        return str;
    }
}
