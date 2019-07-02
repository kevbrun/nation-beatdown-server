package ch.nation.dbservice.entities.skills.effects;

import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.StatType;
import ch.nation.core.model.Enums.TimeReversakSkillEffectRoundDefinition;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.skills.Skill;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity(name="TIME_REVERSAL_SKILL")
@DiscriminatorValue("TIME_REVERSAL_EFFECT")
public class TimeReversalSkillEffect extends SkillEffect implements IDiscrimantorValue {


    @Column(name="reversal_def")
    @Enumerated(EnumType.STRING)
    @JsonProperty("reversal_def")
    private TimeReversakSkillEffectRoundDefinition definition;


    @Column(name="count_of_skills")
    @JsonProperty("count_of_skills")
    private Integer countOfSkillEffectToReverse;


    public TimeReversalSkillEffect() {
        super();
    }

    public TimeReversalSkillEffect(TimeReversakSkillEffectRoundDefinition definition, Integer countOfSkillEffectToReverse) {
        this.definition = definition;
        this.countOfSkillEffectToReverse = countOfSkillEffectToReverse;
    }

    public TimeReversalSkillEffect(SkillEffectTarget effectTarget, StatType typeUsedForCalculation, StatType applyCalculationOnStat, boolean resultIsNegative, List<Skill> skills, TimeReversakSkillEffectRoundDefinition definition, Integer countOfSkillEffectToReverse) {
        super(effectTarget, typeUsedForCalculation, applyCalculationOnStat, resultIsNegative, skills);
        this.definition = definition;
        this.countOfSkillEffectToReverse = countOfSkillEffectToReverse;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeReversalSkillEffect)) return false;
        if (!super.equals(o)) return false;
        TimeReversalSkillEffect that = (TimeReversalSkillEffect) o;
        return definition == that.definition &&
                Objects.equals(countOfSkillEffectToReverse, that.countOfSkillEffectToReverse);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), definition, countOfSkillEffectToReverse);
    }
}
