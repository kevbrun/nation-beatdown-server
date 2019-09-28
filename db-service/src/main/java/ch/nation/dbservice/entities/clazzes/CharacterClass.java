package ch.nation.dbservice.entities.clazzes;


import ch.nation.core.model.Enums.StatGrowthType;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name="CLAZZES")
@Table(name="CLAZZES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

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


    @ManyToMany(cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
  //  @Column(name="skills")

    @JoinTable(name="CLAZZ_TO_SKILL",
            joinColumns={@JoinColumn(name="CLASS_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="SKILL_ID", referencedColumnName="id")})
    @RestResource(path="skill",rel = "skill",exported = false)
    @JsonProperty("skills")
    private List<Skill> skills;

    @OneToMany(
            mappedBy = "characterClass",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true

    )
    @RestResource(path = "units", rel="units")
    @JsonProperty("units")

    private List<Unit> units = new ArrayList<>();

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
        super();
        if(healthPoints==null) healthPoints = new Stat();
        if(actionPoints==null) actionPoints = new Stat();
        if(movementSpeed==null)movementSpeed = new Stat();
        if(strength==null) strength = new Stat();
        if(vitality==null) vitality = new Stat();
        if(intelligence==null) intelligence = new Stat();
        if(dexterity==null) dexterity = new Stat();
        if(agility==null) agility = new Stat();
    }

    public CharacterClass(String name, String description, int level, int exp, int expToLevelUp, List<Skill> skills, List<Unit> units, Stat healthPoints, Stat actionPoints, Stat movementSpeed, Stat strength, Stat vitality, Stat intelligence, Stat dexterity, Stat agility) {
        super(name, description);
        this.level = level;
        this.exp = exp;
        this.expToLevelUp = expToLevelUp;
        this.skills = skills;
        this.units = units;
        this.healthPoints = healthPoints;
        this.actionPoints = actionPoints;
        this.movementSpeed = movementSpeed;
        this.strength = strength;
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.agility = agility;
    }


    public List<Unit> getUnits() {

        //Weak side of relation!
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

        if(skills==null) skills = new ArrayList<>();

        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Stat getHealthPoints() {
        if(healthPoints==null) healthPoints = new Stat();
        return healthPoints;
    }

    public void setHealthPoints(Stat healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Stat getActionPoints() {
        if(actionPoints==null) actionPoints = new Stat();

        return actionPoints;
    }

    public void setActionPoints(Stat actionPoints) {
        this.actionPoints = actionPoints;
    }

    public Stat getMovementSpeed() {

        if(movementSpeed==null) movementSpeed = new Stat();

        return movementSpeed;
    }

    public void setMovementSpeed(Stat movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Stat getStrength() {
        if(strength==null) strength = new Stat();


        return strength;
    }

    public void setStrength(Stat strength) {
        this.strength = strength;
    }

    public Stat getVitality() {

        if(vitality==null) vitality = new Stat();


        return vitality;
    }

    public void setVitality(Stat vitality) {
        this.vitality = vitality;
    }

    public Stat getIntelligence() {
        if(intelligence==null) intelligence = new Stat();


        return intelligence;
    }

    public void setIntelligence(Stat intelligence) {
        this.intelligence = intelligence;
    }

    public Stat getDexterity() {

        if(dexterity==null) dexterity = new Stat();


        return dexterity;
    }

    public void setDexterity(Stat dexterity) {
        this.dexterity = dexterity;
    }

    public Stat getAgility() {
        if(agility==null) agility = new Stat();


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterClass)) return false;
        if (!super.equals(o)) return false;
        CharacterClass that = (CharacterClass) o;
        return level == that.level &&
                exp == that.exp &&
                expToLevelUp == that.expToLevelUp &&
                Objects.equals(skills, that.skills) &&
                Objects.equals(units, that.units) &&
                Objects.equals(healthPoints, that.healthPoints) &&
                Objects.equals(actionPoints, that.actionPoints) &&
                Objects.equals(movementSpeed, that.movementSpeed) &&
                Objects.equals(strength, that.strength) &&
                Objects.equals(vitality, that.vitality) &&
                Objects.equals(intelligence, that.intelligence) &&
                Objects.equals(dexterity, that.dexterity) &&
                Objects.equals(agility, that.agility);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), level, exp, expToLevelUp, skills, units, healthPoints, actionPoints, movementSpeed, strength, vitality, intelligence, dexterity, agility);
    }


    //Connection functions


    public void addSkill(Skill skill){
        if(!getSkills().contains(skill)){
            getSkills().add(skill);
            skill.addCharacterClass(this);

        }
    }

    public void removeSkill(Skill skill){
        if(getSkills().contains(skill)){
            getSkills().remove(skill);
            skill.removeCharacterClass(this);
        }
    }



}
