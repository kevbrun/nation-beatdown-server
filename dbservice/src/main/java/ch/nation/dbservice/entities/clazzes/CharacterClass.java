package ch.nation.dbservice.entities.clazzes;


import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Entity(name="CLASSES")
@Table(name="CLASSES")
public class CharacterClass extends NamedEntityBase {
    @Column(name="lvl")
    @JsonProperty("lvl")
    private int level;

    @Column(name ="exp")
    @JsonProperty("exp")
    private int exp;
    @JsonProperty("exp_for_level_up")
    @Column(name="exp_for_level_up")
    private int expToLevelUp;


    @ManyToMany
    @Column(name="skills")
    @RestResource(path="skill",rel = "skill")
    @JsonProperty("skills")
    private List<Skill> skills;

    @OneToMany(
            mappedBy = "characterClass",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @RestResource(path = "units", rel="units")
    @JsonProperty("units")
    private List<Unit> units;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "hp_base")),
            @AttributeOverride(name = "minValue", column = @Column(name = "hp_min")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "hp_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "hp_growth"))

    })
    @Column(name="hp")
    @JsonProperty("hp")
    private Stat healthPoints;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "ap_base")),
            @AttributeOverride(name = "minValue", column = @Column(name = "ap_min")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "ap_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "ap_growth"))


    })
    @Column(name="ap")
    @JsonProperty("ap")
    private Stat actionPoints;




    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "speed_base")),
            @AttributeOverride(name = "minValue", column = @Column(name = "speed_min")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "speed_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "speed_growth"))


    })
    @Column(name="speed")
    @JsonProperty("speed")
    private Stat movementSpeed;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "str_base")),
            @AttributeOverride(name = "minValue", column = @Column(name = "str_min")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "str_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "str_growth"))


    })
    @Column(name="str")
    @JsonProperty("str")
    private Stat strength;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "vit_base")),
            @AttributeOverride(name = "minValue", column = @Column(name = "vit_min")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "vit_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "vit_growth"))


    })
    @Column(name="vit")
    @JsonProperty("vit")
    private Stat vitality;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "int_base")),
            @AttributeOverride(name = "minValue", column = @Column(name = "int_min")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "int_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "int_growth"))


    })
    @Column(name="int")
    @JsonProperty("int")
    private Stat intelligence;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "dex_base")),
            @AttributeOverride(name = "minValue", column = @Column(name = "dex_min")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "dex_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "dex_growth"))


    })
    @Column(name="dex")
    @JsonProperty("dex")
    private Stat dexterity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "agi_base")),
            @AttributeOverride(name = "minValue", column = @Column(name = "agi_min")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "agi_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "agi_growth"))


    })
    @Column(name="agi")
    @JsonProperty("agi")
    private Stat agility;
//TODO Check if applied stats effect of unity game should be saved too




    public CharacterClass() {
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExpToLevelUp() {
        return expToLevelUp;
    }

    public void setExpToLevelUp(int expToLevelUp) {
        this.expToLevelUp = expToLevelUp;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Stat getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Stat healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Stat getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(Stat actionPoints) {
        this.actionPoints = actionPoints;
    }

    public Stat getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Stat movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Stat getStrength() {
        return strength;
    }

    public void setStrength(Stat strength) {
        this.strength = strength;
    }

    public Stat getVitality() {
        return vitality;
    }

    public void setVitality(Stat vitality) {
        this.vitality = vitality;
    }

    public Stat getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Stat intelligence) {
        this.intelligence = intelligence;
    }

    public Stat getDexterity() {
        return dexterity;
    }

    public void setDexterity(Stat dexterity) {
        this.dexterity = dexterity;
    }

    public Stat getAgility() {
        return agility;
    }

    public void setAgility(Stat agility) {
        this.agility = agility;
    }




    @Override
    public String toString() {
        return "CharacterClass{" +
                "level=" + level +
                ", exp=" + exp +
                ", expToLevelUp=" + expToLevelUp +
                ", skills=" + skills +
                ", healthPoints=" + healthPoints +
                ", actionPoints=" + actionPoints +
                ", movementSpeed=" + movementSpeed +
                ", strength=" + strength +
                ", vitality=" + vitality +
                ", intelligence=" + intelligence +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                "} " + super.toString();
    }


    //Connection functions

    public void addSkill(Skill skill){
        if(!skills.contains(skill)){
            skills.add(skill);
            skill.addCharacterClass(this);

        }
    }

    public void removeSkill(Skill skill){
        if(skills.contains(skill)){
            skills.remove(skill);
            skill.removeCharacterClass(this);
        }
    }
}
