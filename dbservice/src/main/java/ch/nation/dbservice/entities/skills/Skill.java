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
import java.util.ArrayList;
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



    @ManyToMany(mappedBy = "skills",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonProperty("clazz")
    private List<CharacterClass> characterClasses;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "SKILL_SKILL_EFFECTS",
            joinColumns = { @JoinColumn(name = "skill_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_effect_id") }
    )
    @RestResource(path="effects",rel = "effects")
    private List<SkillEffect> skillEffects;

    @OneToMany(mappedBy = "skill",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<SkillCharacteristic> skillCharacteristic = new ArrayList<>();



    @OneToMany
            (
                    mappedBy = "skill",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<PlayerMoveAction> actions = new ArrayList<>();



    public Skill() {
        super();
    }


    public List<SkillCharacteristic> getSkillCharacteristic() {
        if(skillCharacteristic==null)skillCharacteristic = new ArrayList<>();
        return skillCharacteristic;
    }

    public void setSkillCharacteristic(List<SkillCharacteristic> skillCharacteristic) {
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

        if(actionArea==null)actionArea = new ActionArea();

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

        if(characterClasses==null) characterClasses = new ArrayList<>();


        return characterClasses;
    }

    public void setCharacterClasses(List<CharacterClass> characterClasses) {
        this.characterClasses = characterClasses;
    }

    public List<SkillEffect> getSkillEffects() {
        if(skillEffects==null) skillEffects = new ArrayList<>();

        return skillEffects;
    }

    public void setSkillEffects(List<SkillEffect> skillEffects) {
        this.skillEffects = skillEffects;
    }


    public List<PlayerMoveAction> getActions() {
        return actions;
    }

    public void setActions(List<PlayerMoveAction> actions) {
        this.actions = actions;
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
        if(getSkillEffects()!=null) {
            this.getSkillEffects().add(skillEffect);
            skillEffect.getSkills().add(this);
        }
    }

    public void removeSkillEffect(SkillEffect skillEffect){
        if(this.getSkillEffects()!=null){
            this.skillEffects.remove(skillEffect);
            skillEffect.getSkills().remove(this);
        }
    }

    public void addCharacterClass(CharacterClass clazz){
        if(!getCharacterClasses().contains(clazz)){
            getCharacterClasses().add(clazz);
            clazz.addSkill(this);

        }
    }

    public void removeCharacterClass(CharacterClass clazz){
        if(getCharacterClasses().contains(clazz)){
            getCharacterClasses().remove(clazz);
            clazz.removeSkill(this);
        }
    }

    public void addSkillCharacteristic(SkillCharacteristic characteristic){
        if(!getSkillCharacteristic().contains(characteristic)){
            getSkillCharacteristic().add(characteristic);
            characteristic.addSkill(this);
        }
    }


    public void removeSkillCharacteristics(SkillCharacteristic characteristic){
        if(getSkillCharacteristic().contains(characteristic)){
            getSkillCharacteristic().remove(characteristic);
            characteristic.setSkill(null);
        }
    }

}
