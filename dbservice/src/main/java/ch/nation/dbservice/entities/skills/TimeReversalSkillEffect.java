package ch.nation.dbservice.entities.skills;

import ch.nation.core.model.Enums.TimeReversakSkillEffectRoundDefinition;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity(name="TIME_REVERSAL_SKILL")
@DiscriminatorValue("TIME_REVERSAL_SKILL_EFFECT")
public class TimeReversalSkillEffect extends SkillEffect{


    @Column(name="reversal_def")
    @Enumerated(EnumType.STRING)
    @JsonProperty("reversal_def")
    private TimeReversakSkillEffectRoundDefinition definition;


    @Column(name="count_of_skills")
    @JsonProperty("count_of_skills")
    private Integer countOfSkillEffectToReverse;


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

}
