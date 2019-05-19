package ch.nation.dbservice.entities.Skills;

import ch.nation.dbservice.entities.NationEntityBase;
import ch.nation.dbservice.entities.enums.SkillEffectTarget;
import ch.nation.dbservice.entities.enums.StatType;
import ch.nation.dbservice.entities.enums.TimeReversakSkillEffectRoundDefinition;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Table(name="SKILL_EFFECTS")
@Entity(name="SKILL_EFFECTS")
public class SkillEffect extends NationEntityBase {

    @Column(name="effectTarget")
    @Enumerated(EnumType.STRING)
    private SkillEffectTarget effectTarget;

    @Column(name="calcSource")
    @Enumerated(EnumType.STRING)
    private StatType typeUsedForCalculation;

    @Column(name="calcTarget")
    @Enumerated(EnumType.STRING)
    private StatType applyCalculationOnStat;

    @Column(name="negative")
    private boolean resultIsNegative;

    @ManyToMany(mappedBy = "skillEffects")
    private List<Skill> skills;



    //Time Reversal Skill Effect properties hide if null for jsonConverter
    @Column(name="reversal_def")
    @Enumerated(EnumType.STRING)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TimeReversakSkillEffectRoundDefinition definition;

    @Column(name="count_of_skills")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Value("#{countOfSkillEffectToReverse == 0 ?  countOfSkillEffectToReverse : null}")
    private Integer countOfSkillEffectToReverse;


    public SkillEffect() {
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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
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
        return "SkillEffect{" +
                "effectTarget=" + effectTarget +
                ", typeUsedForCalculation=" + typeUsedForCalculation +
                ", applyCalculationOnStat=" + applyCalculationOnStat +
                ", resultIsNegative=" + resultIsNegative +
                "} " + super.toString();
    }

    //REGION NOT GENERATED FUNCTIONS

    public void addSkill(Skill skill){
        if(skill!=null){
            this.getSkills().add(skill);
            skill.getSkillEffects().add(this);
        }
    }

    public void removeSkill(Skill skill){
        if(skill!=null){
            this.getSkills().remove(skill);
            skill.getSkillEffects().remove(this);
        }
    }


}
