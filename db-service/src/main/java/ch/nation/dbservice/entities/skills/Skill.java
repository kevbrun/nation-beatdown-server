package ch.nation.dbservice.entities.skills;


import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.NationRessource;
import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.core.model.Enums.Target;
import ch.nation.dbservice.entities.prejudices.SkillPrejudice;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.entities.units.Unit;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="SKILLS")
@Entity(name="SKILLS")
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name="SKILL_TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BASE_SKILL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Skill extends NationRessource implements IDiscrimantorValue {


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

    @Column(name="skill_target",nullable = false)
    @JsonProperty("skill_target")
    @Enumerated(EnumType.STRING)
    private Target target;




    @ManyToMany(mappedBy = "skills",fetch=FetchType.EAGER)
    @JsonProperty("clazz")
    private List<CharacterClass> characterClasses;


    @ManyToMany(cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "SKILL_SKILL_EFFECTS",
            joinColumns = { @JoinColumn(name = "skill_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_effect_id") }
    )
    @RestResource(path="effects",rel = "effects",exported = false)
    @JsonProperty("effects")
    private List<SkillEffect> skillEffects;

    @OneToMany(mappedBy = "skill",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    @JsonIgnore
    @RestResource(exported = false)
    private List<SkillCharacteristic> skillCharacteristic;


    @OneToMany(mappedBy = "skill",fetch = FetchType.LAZY)
    @JsonProperty("prejudices")
    private List<SkillPrejudice> skillPrejudices;


    @OneToMany(
            mappedBy = "skill",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    @RestResource(exported = false  )
    private List<BasePlayerMove> actions = new ArrayList<>();



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

    public List<SkillPrejudice> getSkillPrejudices() {
        return skillPrejudices;
    }

    public void setSkillPrejudices(List<SkillPrejudice> skillPrejudices) {
        if(skillPrejudices==null) skillPrejudices = new ArrayList<>();
        this.skillPrejudices = skillPrejudices;
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


    public List<BasePlayerMove> getActions() {
        return actions;
    }

    public void setActions(List<BasePlayerMove> actions) {
        LOGGER.debug("Execute custom setter");
        if (this.actions == null) {
            this.actions = actions;
        } else if(this.actions != actions) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.actions.clear();
            if(actions != null){
                this.actions.addAll(actions);
            }
        }




    }

    @Override
    public String toString() {
        return this.getClass().getName()+"{" +
                "cost=" + cost +
                ", baseValue=" + baseValue +
                ", cooldown=" + cooldown +
                ", currentCooldownTimer=" + currentCooldownTimer +
                ", skillBarOrder=" + skillBarOrder +
                ", actionArea=" + actionArea +
                ", target=" + target +
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

    public void removeMove(BasePlayerMove move){
       if(getActions().contains(move)){
           getActions().remove(move);
           move.setSkill(null);
       }
    }

}
