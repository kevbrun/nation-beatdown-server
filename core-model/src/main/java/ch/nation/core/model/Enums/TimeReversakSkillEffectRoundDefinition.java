package ch.nation.core.model.Enums;


import ch.nation.core.utils.EnumUtilties;

public enum TimeReversakSkillEffectRoundDefinition implements IEnumFromValue<TimeReversakSkillEffectRoundDefinition> {
    COMPLETE_ROUND("CompleteRound"), STEP("Step");

    private String str;

    TimeReversakSkillEffectRoundDefinition(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "TimeReversakSkillEffectRoundDefinition{" +
                "str='" + str + '\'' +
                "} " + super.toString();
    }


    public TimeReversakSkillEffectRoundDefinition fromValue(String value) {
        return EnumUtilties.getEnumFromString(TimeReversakSkillEffectRoundDefinition.class, value);
    }


    public String toJson() {
        return str;
    }
}
