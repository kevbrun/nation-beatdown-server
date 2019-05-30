package ch.nation.dbservice.entities.skills;


import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.moves.PlayerMoveAction;
import ch.nation.core.model.Enums.Target;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Table(name="SKILLS")
@Entity(name="SKILLS")
public class Skill extends NamedEntityBase {


    @Column(name="cost")
    @JsonProperty("cost")
    private int cost;

    @Column(name="base_value")
    @JsonProperty("base_value")
    private int baseValue;

    @Column(name="cooldown")
    @JsonProperty("cooldown")
    private int cooldown;

    @Column(name="current_cooldown")
    @JsonProperty("current_cooldown")
    private int currentCooldownTimer;

    @Column(name="skill_bar_order")
    @JsonProperty("skill_bar_order")
    private int skillBarOrder;

    @Column(name="area")
    @JsonProperty("area")
    private ActionArea actionArea;

    @Column(name="skill_target")
    @JsonProperty("skill_target")
    @Enumerated(EnumType.STRING)
    private Target target;



    @ManyToMany(mappedBy = "skills")
    @JsonProperty("clazz")
    private List<CharacterClass> characterClasses;


    @ManyToMany
    @Column(name="skill_effects")
    @JsonProperty("skill_effects")
    @RestResource(path="effects",rel = "effects")
    private List<SkillEffect> skillEffects;

    @OneToOne(mappedBy = "skill")
    @JsonIgnore
    private SkillCharacteristic skillCharacteristic;


    @OneToMany(
            mappedBy = "skill",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlayerMoveAction> actions;



    public Skill() {
    }


    public SkillCharacteristic getSkillCharacteristic() {
        return skillCharacteristic;
    }

    public void setSkillCharacteristic(SkillCharacteristic skillCharacteristic) {
        this.skillCharacteristic = skillCharacteristic;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCurrentCooldownTimer() {
        return currentCooldownTimer;
    }

    public void setCurrentCooldownTimer(int currentCooldownTimer) {
        this.currentCooldownTimer = currentCooldownTimer;
    }

    public int getSkillBarOrder() {
        return skillBarOrder;
    }

    public void setSkillBarOrder(int skillBarOrder) {
        this.skillBarOrder = skillBarOrder;
    }

    public ActionArea getActionArea() {
        return actionArea;
    }

    public void setActionArea(ActionArea actionArea) {
        this.actionArea = actionArea;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public List<CharacterClass> getCharacterClasses() {
        return characterClasses;
    }

    public void setCharacterClasses(List<CharacterClass> characterClasses) {
        this.characterClasses = characterClasses;
    }

    public List<SkillEffect> getSkillEffects() {
        return skillEffects;
    }

    public void setSkillEffects(List<SkillEffect> skillEffects) {
        this.skillEffects = skillEffects;
    }


    @Override
    public String toString() {
        return "Skill{" +
                "cost=" + cost +
                ", baseValue=" + baseValue +
                ", cooldown=" + cooldown +
                ", currentCooldownTimer=" + currentCooldownTimer +
                ", skillBarOrder=" + skillBarOrder +
                ", actionArea=" + actionArea +
                ", target=" + target +
                ", characterClasses=" + characterClasses +
                ", skillEffects=" + skillEffects +
                "} " + super.toString();
    }


        //REGION NOT GENERATED FUNCTIONS

    public void addSkillEffect(SkillEffect skillEffect){
        if(skillEffect!=null) {
            this.skillEffects.add(skillEffect);
            skillEffect.getSkills().add(this);
        }
    }

    public void removeSkillEffect(SkillEffect skillEffect){
        if(skillEffect!=null){
            this.skillEffects.remove(skillEffect);
            skillEffect.getSkills().remove(this);
        }
    }

    public void addCharacterClass(CharacterClass clazz){
        if(!characterClasses.contains(clazz)){
            characterClasses.add(clazz);
            clazz.addSkill(this);

        }
    }

    public void removeCharacterClass(CharacterClass clazz){
        if(characterClasses.contains(clazz)){
            characterClasses.remove(clazz);
            clazz.removeSkill(this);
        }
    }



}
