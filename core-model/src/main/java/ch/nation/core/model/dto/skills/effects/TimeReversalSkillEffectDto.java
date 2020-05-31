package ch.nation.core.model.dto.skills.effects;

import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.StatType;
import ch.nation.core.model.Enums.TimeReversakSkillEffectRoundDefinition;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TimeReversalSkillEffectDto extends SkillEffectDto {

    @JsonProperty("reversal_def")
    private TimeReversakSkillEffectRoundDefinition definition;


    @JsonProperty("count_of_skills")
    private Integer countOfSkillEffectToReverse;


    public TimeReversalSkillEffectDto(SkillEffectTarget effectTarget, StatType typeUsedForCalculation, StatType applyCalculationOnStat, boolean resultIsNegative) {
        super(effectTarget, typeUsedForCalculation, applyCalculationOnStat, resultIsNegative);
    }

    public TimeReversalSkillEffectDto() {
    }


    public TimeReversakSkillEffectRoundDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(TimeReversakSkillEffectRoundDefinition definition) {
        this.definition = definition;
    }

    public Integer getCountOfSkillEffectToReverse() {
        return countOfSkillEffectToReverse;
    }

    public void setCountOfSkillEffectToReverse(Integer countOfSkillEffectToReverse) {
        this.countOfSkillEffectToReverse = countOfSkillEffectToReverse;
    }

    @Override
    public String toString() {
        return "TimeReversalSkillEffectDto{" +
                "definition=" + definition +
                ", countOfSkillEffectToReverse=" + countOfSkillEffectToReverse +
                "} " + super.toString();
    }
}
