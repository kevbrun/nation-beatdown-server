package ch.nation.dbservice.entities.Clazzes;


import ch.nation.dbservice.entities.NationEntityBase;
import ch.nation.dbservice.entities.Skills.Skill;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name="CLASSES")
@Table(name="CLASSES")
public class CharacterClasses extends NationEntityBase {
    @Column(name="lvl")
    private int level;

    @Column(name ="exp")
    private int exp;
    @Column(name="exp_for_level_up")
    private int expToLevelUp;


    @OneToMany(mappedBy = "characterClasses")
    private List<Skill> skills;



    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "hp_base")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "hp_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "hp_growth"))

    })
    @Embedded
    private Stat healthPoints;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "ap_base")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "ap_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "ap_growth"))


    })
    private Stat actionPoints;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "speed_base")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "speed_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "speed_growth"))


    })
    private Stat movementSpeed;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "str_base")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "str_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "str_growth"))


    })
    private Stat strength;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "vit_base")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "vit_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "vit_growth"))


    })
    private Stat vitality;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "int_base")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "int_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "int_growth"))


    })
    private Stat intelligence;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "dex_base")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "dex_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "dex_growth"))


    })
    private Stat dexterity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "baseValue", column = @Column(name = "agi_base")),
            @AttributeOverride(name = "maxValue", column = @Column(name = "agi_max")),
            @AttributeOverride(name = "growthType", column = @Column(name = "agi_growth"))


    })
    private Stat agility;
//TODO Check if applied stats effect of unity game should be saved too


    public CharacterClasses(UUID id, String name, String description, int level, int exp, int expToLevelUp, List<Skill> skills, Stat healthPoints, Stat actionPoints, Stat movementSpeed, Stat strength, Stat vitality, Stat intelligence, Stat dexterity, Stat agility) {
        super(id, name, description);
        this.level = level;
        this.exp = exp;
        this.expToLevelUp = expToLevelUp;
        this.skills = skills;
        this.healthPoints = healthPoints;
        this.actionPoints = actionPoints;
        this.movementSpeed = movementSpeed;
        this.strength = strength;
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.agility = agility;
    }

    public CharacterClasses(int level, int exp, int expToLevelUp, List<Skill> skills, Stat healthPoints, Stat actionPoints, Stat movementSpeed, Stat strength, Stat vitality, Stat intelligence, Stat dexterity, Stat agility) {
        this.level = level;
        this.exp = exp;
        this.expToLevelUp = expToLevelUp;
        this.skills = skills;
        this.healthPoints = healthPoints;
        this.actionPoints = actionPoints;
        this.movementSpeed = movementSpeed;
        this.strength = strength;
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.agility = agility;
    }

    public CharacterClasses(String name, int level, int exp, int expToLevelUp, ArrayList<Skill> skills, Stat healthPoints, Stat actionPoints, Stat movementSpeed, Stat strength, Stat vitality, Stat intelligence, Stat dexterity, Stat agility) {
        super(name);
        this.level = level;
        this.exp = exp;
        this.expToLevelUp = expToLevelUp;
        this.skills = skills;
        this.healthPoints = healthPoints;
        this.actionPoints = actionPoints;
        this.movementSpeed = movementSpeed;
        this.strength = strength;
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.agility = agility;
    }


    public CharacterClasses() {
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
        return "CharacterClasses{" +
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
}
