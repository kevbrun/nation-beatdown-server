package ch.nation.core.model.dto.skills.effects;

import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.StatType;
import ch.nation.core.model.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value =SkillEffectDto.class, name = "BASE"),
        @JsonSubTypes.Type(value =TimeReversalSkillEffectDto.class, name = "TIME_REVERSAL"),
})
public class AbstractSkillEffectDto extends AbstractDto {

    @JsonProperty("effectTarget")
    private SkillEffectTarget effectTarget;


    @JsonProperty("calcSource")
    private StatType typeUsedForCalculation;


    @JsonProperty("calcTarget")
    private StatType applyCalculationOnStat;


    @JsonProperty("negative")
    private boolean resultIsNegative;

    public AbstractSkillEffectDto(SkillEffectTarget effectTarget, StatType typeUsedForCalculation, StatType applyCalculationOnStat, boolean resultIsNegative) {
        this.effectTarget = effectTarget;
        this.typeUsedForCalculation = typeUsedForCalculation;
        this.applyCalculationOnStat = applyCalculationOnStat;
        this.resultIsNegative = resultIsNegative;
    }

    public AbstractSkillEffectDto() {
    }

    public SkillEffectTarget getEffectTarget() {
        return effectTarget;
    }

    public void setEffectTarget(SkillEffectTarget effectTarget) {
        this.effectTarget = effectTarget;
    }

    public StatType getTypeUsedForCalculation() {
        return typeUsedForCalculation;
    }

    public void setTypeUsedForCalculation(StatType typeUsedForCalculation) {
        this.typeUsedForCalculation = typeUsedForCalculation;
    }

    public StatType getApplyCalculationOnStat() {
        return applyCalculationOnStat;
    }

    public void setApplyCalculationOnStat(StatType applyCalculationOnStat) {
        this.applyCalculationOnStat = applyCalculationOnStat;
    }

    public boolean isResultIsNegative() {
        return resultIsNegative;
    }

    public void setResultIsNegative(boolean resultIsNegative) {
        this.resultIsNegative = resultIsNegative;
    }

    @Override
    public String toString() {
        return "AbstractSkillEffectDto{" +
                "effectTarget=" + effectTarget +
                ", typeUsedForCalculation=" + typeUsedForCalculation +
                ", applyCalculationOnStat=" + applyCalculationOnStat +
                ", resultIsNegative=" + resultIsNegative +
                "} " + super.toString();
    }
}
