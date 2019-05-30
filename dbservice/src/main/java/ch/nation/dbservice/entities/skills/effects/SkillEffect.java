package ch.nation.dbservice.entities.skills.effects;

import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.StatType;
import ch.nation.dbservice.entities.skills.Skill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Table(name="SKILL_EFFECTS")
@Entity(name="SKILL_EFFECTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="SKILL_EFFECT_TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BASE")
public class SkillEffect extends NamedEntityBase {

    @Column(name="effectTarget")
    @Enumerated(EnumType.STRING)
    @JsonProperty("effectTarget")
    private SkillEffectTarget effectTarget;

    @Column(name="calcSource")
    @Enumerated(EnumType.STRING)
    @JsonProperty("calcSource")
    private StatType typeUsedForCalculation;

    @Column(name="calcTarget")
    @Enumerated(EnumType.STRING)
    @JsonProperty("calcTarget")
    private StatType applyCalculationOnStat;

    @Column(name="negative")
    @JsonProperty("negative")
    private boolean resultIsNegative;

    @ManyToMany(mappedBy = "skillEffects")
    @JsonIgnore
    @RestResource(path = "skills", rel="skills")
    private List<Skill> skills;





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
