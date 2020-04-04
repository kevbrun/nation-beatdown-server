package ch.nation.dbservice.entities.skills.effects;

import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.StatType;
import ch.nation.dbservice.entities.NationRessource;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import ch.nation.dbservice.entities.skills.Skill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "SKILL_EFFECTS")
@Entity(name = "SKILL_EFFECTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SKILL_EFFECT_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BASE")
public class SkillEffect extends NationRessource implements IDiscrimantorValue {

    @Column(name = "effectTarget", nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty("effectTarget")
    private SkillEffectTarget effectTarget = SkillEffectTarget.NONE;

    @Column(name = "calcSource", nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty("calcSource")
    private StatType typeUsedForCalculation = StatType.NONE;

    @Column(name = "calcTarget", nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty("calcTarget")
    private StatType applyCalculationOnStat = StatType.NONE;

    @Column(name = "negative")
    @JsonProperty("negative")
    private boolean resultIsNegative = true;

    @ManyToMany(mappedBy = "skillEffects", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @RestResource(path = "skills", rel = "skills")
    private List<Skill> skills;


    /**
     * @ManyToMany(mappedBy = "appliedEffects",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
     * private List<BasePlayerMove> playerMoves;
     **/


    @OneToMany(mappedBy = "skillEffect", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @RestResource(path = "moves", rel = "moves")
    private List<BasePlayerMoveValue> moveValues;

    @JsonProperty("animations")
    @ElementCollection
    @CollectionTable(
            name="SKILL_EFFECT_ANIMATION_INFO",
            joinColumns=@JoinColumn(name="ANIM_ID")
    )
    private List<SkillAnimationInfo> info;


    public SkillEffect() {
        super();
        moveValues = new ArrayList<>();

    }


    public SkillEffect(SkillEffectTarget effectTarget, StatType typeUsedForCalculation, StatType applyCalculationOnStat, boolean resultIsNegative, List<Skill> skills) {
        this.effectTarget = effectTarget;
        this.typeUsedForCalculation = typeUsedForCalculation;
        this.applyCalculationOnStat = applyCalculationOnStat;
        this.resultIsNegative = resultIsNegative;
        this.skills = skills;
    }


    public List<SkillAnimationInfo> getInfo() {
        return info;
    }

    public void setInfo(List<SkillAnimationInfo> info) {
        this.info = info;
    }

    public List<BasePlayerMoveValue> getMoveValues() {
        return moveValues;
    }

    public void setMoveValues(List<BasePlayerMoveValue> moveValues) {
        this.moveValues = moveValues;
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


        if (skills == null) skills = new ArrayList<>();

        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }


    /**
     * public List<BasePlayerMove> getPlayerMoves() {
     * return playerMoves;
     * }
     * <p>
     * public void setPlayerMoves(List<BasePlayerMove> playerMoves) {
     * this.playerMoves = playerMoves;
     * }
     **/

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

    public void addSkill(Skill skill) {
        if (getSkills() != null) {
            this.getSkills().add(skill);
            skill.getSkillEffects().add(this);
        }
    }




    public void removeSkill(Skill skill) {
        if (this.getSkills() != null) {
            this.getSkills().remove(skill);
            skill.getSkillEffects().remove(this);
        }
    }

    public void removeMoveValue(BasePlayerMoveValue value) {
        if (getMoveValues().contains(value)) {
            getMoveValues().remove(value);
            value.setSkillEffect(null);
        }
    }

    public void addAnimInfo(SkillAnimationInfo info){
        if(this.getInfo()==null) setInfo(new ArrayList<SkillAnimationInfo>());

        if(info!=null){
            getInfo().add(info);
        }

    }


    public void removeAnimInfo(SkillAnimationInfo info){
        if(this.getInfo()!=null && this.getInfo().size()>0){
            this.getInfo().remove(info);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillEffect)) return false;
        if (!super.equals(o)) return false;
        SkillEffect that = (SkillEffect) o;
        return resultIsNegative == that.resultIsNegative &&
                effectTarget == that.effectTarget &&
                typeUsedForCalculation == that.typeUsedForCalculation &&
                applyCalculationOnStat == that.applyCalculationOnStat &&
                Objects.equals(skills, that.skills);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), effectTarget, typeUsedForCalculation, applyCalculationOnStat, resultIsNegative, skills);
    }
}
