package ch.nation.dbservice.entities;


import ch.nation.dbservice.entities.enums.Target;

import javax.persistence.*;
import java.util.UUID;

@Table(name="SKILLS")
@Entity(name="SKILLS")
public class Skill extends NationEntityBase{


    @Column(name="cost")
    private int cost;

    @Column(name="base_value")
    private int baseValue;

    @Column(name="cooldown")
    private int cooldown;

    @Column(name="current_cooldown")
    private int currentCooldownTimer;

    @Column(name="skill_bar_order")
    private int skillBarOrder;

    @Column(name="area")
    private ActionArea actionArea;

    @Column(name="skill_target")
    @Enumerated(EnumType.STRING)
    private Target target;

    @ManyToOne
    @JoinColumn(name = "clazz_id", insertable = false, updatable = false)
    private CharacterClasses characterClasses;


    /** TODO SKILL_EFFECTS **/


    public Skill(UUID id, String name, String description, int cost, int baseValue, int cooldown, int currentCooldownTimer, int skillBarOrder, ActionArea actionArea, Target target, CharacterClasses characterClasses) {
        super(id, name, description);
        this.cost = cost;
        this.baseValue = baseValue;
        this.cooldown = cooldown;
        this.currentCooldownTimer = currentCooldownTimer;
        this.skillBarOrder = skillBarOrder;
        this.actionArea = actionArea;
        this.target = target;
        this.characterClasses = characterClasses;
    }

    public Skill(int cost, int baseValue, int cooldown, int currentCooldownTimer, int skillBarOrder, ActionArea actionArea, Target target, CharacterClasses characterClasses) {
        this.cost = cost;
        this.baseValue = baseValue;
        this.cooldown = cooldown;
        this.currentCooldownTimer = currentCooldownTimer;
        this.skillBarOrder = skillBarOrder;
        this.actionArea = actionArea;
        this.target = target;
        this.characterClasses = characterClasses;
    }

    public Skill(String name, int cost, int baseValue, int cooldown, int currentCooldownTimer, int skillBarOrder, ActionArea actionArea, Target target, CharacterClasses characterClasses) {
        super(name);
        this.cost = cost;
        this.baseValue = baseValue;
        this.cooldown = cooldown;
        this.currentCooldownTimer = currentCooldownTimer;
        this.skillBarOrder = skillBarOrder;
        this.actionArea = actionArea;
        this.target = target;
        this.characterClasses = characterClasses;
    }

    public Skill() {
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

    public CharacterClasses getCharacterClasses() {
        return characterClasses;
    }

    public void setCharacterClasses(CharacterClasses characterClasses) {
        this.characterClasses = characterClasses;
    }
}
