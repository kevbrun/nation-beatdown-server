package ch.nation.dbservice.entities.enums;

import ch.nation.dbservice.utils.EnumUtilties;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TimeReversakSkillEffectRoundDefinition implements IEnumFromValue<TimeReversakSkillEffectRoundDefinition> {
    COMPLETE_ROUND("CompleteRound"),STEP("Step");

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
        return EnumUtilties.getEnumFromString(TimeReversakSkillEffectRoundDefinition.class,value);
    }



    public String toJson() {
        return str;
    }
}
