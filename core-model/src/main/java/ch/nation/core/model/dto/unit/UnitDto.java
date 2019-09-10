package ch.nation.core.model.dto.unit;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.position.Vector3Float;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitDto extends NamedObjectAbstractDto {


    @JsonProperty("class")
    private CharacterClassDto characterClass;

    @JsonProperty("state")

    private UnitState state;

    @JsonProperty("dead")
    private Boolean isDead;


    @JsonProperty("pos")

    private Vector3Float position;

    @JsonProperty("assets")
    private UnitAssetsDto unitAssets = new UnitAssetsDto();


    @JsonProperty("hp")
    private int healthPoints;


    @JsonProperty("ap")
    private int actionPoints;


    @JsonProperty("str")
    private int strength;


    @JsonProperty("vit")
    private int vitality;


    @JsonProperty("int")
    private int intelligence;


    @JsonProperty("dex")
    private int dexterity;


    @JsonProperty("agi")
    private int agility;

    public UnitDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "units";
    }

    public UnitDto(CharacterClassDto characterClass, UnitState state, Boolean isDead, Vector3Float position, UnitAssetsDto unitAssets) {
        this.characterClass = characterClass;
        this.state = state;
        this.isDead = isDead;
        this.position = position;
        this.unitAssets = unitAssets;
    }


    public CharacterClassDto getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClassDto characterClass) {
        this.characterClass = characterClass;
    }

    public UnitState getState() {
        return state;
    }

    public Boolean getDead() {
        return isDead;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setState(UnitState state) {
        this.state = state;
    }

    public Boolean isDead() {
        return isDead;
    }

    public void setDead(Boolean dead) {
        isDead = dead;
    }

    public Vector3Float getPosition() {
        return position;
    }

    public void setPosition(Vector3Float position) {
        this.position = position;
    }

    public UnitAssetsDto getUnitAssets() {
        return unitAssets;
    }

    public void setUnitAssets(UnitAssetsDto unitAssets) {
        this.unitAssets = unitAssets;
    }

    @Override
    public String toString() {
        return "UnitDto{" +
                "characterClass=" + characterClass +
                ", state=" + state +
                ", isDead=" + isDead +
                ", position=" + position +
                ", unitAssets=" + unitAssets +
                "} " + super.toString();
    }
}
