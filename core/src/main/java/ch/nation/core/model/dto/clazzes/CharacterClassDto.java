package ch.nation.core.model.dto.clazzes;

import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.unit.UnitDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CharacterClassDto extends NamedObjectAbstractDto {


    @JsonProperty("lvl")
    private int level;

    @JsonProperty("exp")
    private int exp;
    @JsonProperty("exp_for_level_up")
    private int expToLevelUp;


    @JsonProperty("skills")
    private List<SkillDto> skills;


    @JsonProperty("units")
    private List<UnitDto> units;


    @JsonProperty("hp")
    private StatDto healthPoints;


    @JsonProperty("ap")
    private StatDto actionPoints;


    @JsonProperty("speed")
    private StatDto movementSpeed;


    @JsonProperty("str")
    private StatDto strength;


    @JsonProperty("vit")
    private StatDto vitality;


    @JsonProperty("int")
    private StatDto intelligence;


    @JsonProperty("dex")
    private StatDto dexterity;

    @JsonProperty("agi")
    private StatDto agility;


    public CharacterClassDto(int level, int exp, int expToLevelUp, List<SkillDto> skills, List<UnitDto> units, StatDto healthPoints, StatDto actionPoints, StatDto movementSpeed, StatDto strength, StatDto vitality, StatDto intelligence, StatDto dexterity, StatDto agility) {
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

    public CharacterClassDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "classes";
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

    public List<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }

    public List<UnitDto> getUnits() {
        return units;
    }

    public void setUnits(List<UnitDto> units) {
        this.units = units;
    }

    public StatDto getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(StatDto healthPoints) {
        this.healthPoints = healthPoints;
    }

    public StatDto getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(StatDto actionPoints) {
        this.actionPoints = actionPoints;
    }

    public StatDto getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(StatDto movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public StatDto getStrength() {
        return strength;
    }

    public void setStrength(StatDto strength) {
        this.strength = strength;
    }

    public StatDto getVitality() {
        return vitality;
    }

    public void setVitality(StatDto vitality) {
        this.vitality = vitality;
    }

    public StatDto getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(StatDto intelligence) {
        this.intelligence = intelligence;
    }

    public StatDto getDexterity() {
        return dexterity;
    }

    public void setDexterity(StatDto dexterity) {
        this.dexterity = dexterity;
    }

    public StatDto getAgility() {
        return agility;
    }

    public void setAgility(StatDto agility) {
        this.agility = agility;
    }

    @Override
    public String toString() {
        return "CharacterClassDto{" +
                "level=" + level +
                ", exp=" + exp +
                ", expToLevelUp=" + expToLevelUp +
                ", skills=" + skills +
                ", units=" + units +
                ", healthPoints=" + healthPoints +
                ", actionPoints=" + actionPoints +
                ", movementSpeed=" + movementSpeed +
                ", strength=" + strength +
                ", vitality=" + vitality +
                ", intelligence=" + intelligence +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                '}';
    }
}
