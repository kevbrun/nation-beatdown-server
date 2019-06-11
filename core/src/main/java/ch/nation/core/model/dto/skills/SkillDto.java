package ch.nation.core.model.dto.skills;

import ch.nation.core.model.Enums.Target;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.skills.effects.AbstractSkillEffectDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SkillDto extends AbstractDto {

    @JsonProperty("cost")
    private int cost;


    @JsonProperty("base_value")
    private int baseValue;


    @JsonProperty("cooldown")
    private int cooldown;


    @JsonProperty("current_cooldown")
    private int currentCooldownTimer;


    @JsonProperty("skill_bar_order")
    private int skillBarOrder;

    @JsonProperty("area")
    private ActionAreaDto actionArea;


    @JsonProperty("skill_target")
    private Target target;

    @JsonProperty("clazz")
    private List<CharacterClassDto> characterClasses;

    @JsonProperty("skill_effects")
    private List<AbstractSkillEffectDto> skillEffects;


    @JsonProperty("moves")
    private List<AbstractPlayerMoveDto> actions;


    public SkillDto(int cost, int baseValue, int cooldown, int currentCooldownTimer, int skillBarOrder, ActionAreaDto actionArea, Target target, List<CharacterClassDto> characterClasses, List<AbstractSkillEffectDto> skillEffects, List<AbstractPlayerMoveDto> actions) {
        this.cost = cost;
        this.baseValue = baseValue;
        this.cooldown = cooldown;
        this.currentCooldownTimer = currentCooldownTimer;
        this.skillBarOrder = skillBarOrder;
        this.actionArea = actionArea;
        this.target = target;
        this.characterClasses = characterClasses;
        this.skillEffects = skillEffects;
        this.actions = actions;
    }

    public SkillDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "skills";
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

    public ActionAreaDto getActionArea() {
        return actionArea;
    }

    public void setActionArea(ActionAreaDto actionArea) {
        this.actionArea = actionArea;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public List<CharacterClassDto> getCharacterClasses() {
        return characterClasses;
    }

    public void setCharacterClasses(List<CharacterClassDto> characterClasses) {
        this.characterClasses = characterClasses;
    }

    public List<AbstractSkillEffectDto> getSkillEffects() {
        return skillEffects;
    }

    public void setSkillEffects(List<AbstractSkillEffectDto> skillEffects) {
        this.skillEffects = skillEffects;
    }

    public List<AbstractPlayerMoveDto> getActions() {
        return actions;
    }

    public void setActions(List<AbstractPlayerMoveDto> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "SkillDto{" +
                "cost=" + cost +
                ", baseValue=" + baseValue +
                ", cooldown=" + cooldown +
                ", currentCooldownTimer=" + currentCooldownTimer +
                ", skillBarOrder=" + skillBarOrder +
                ", actionArea=" + actionArea +
                ", target=" + target +
                ", characterClasses=" + characterClasses +
                ", skillEffects=" + skillEffects +
                ", actions=" + actions +
                "} " + super.toString();
    }
}
