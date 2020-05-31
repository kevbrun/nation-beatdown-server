package ch.nation.dbservice.entities.units;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface UnitBaseFields {


    @JsonProperty("class")
    CharacterClass getCharacterClass();

    @JsonProperty("state")
    UnitState getState();

    @JsonProperty("pos")
    EmeddableVector3 getPosition();

    @JsonProperty("assets")
    UnitAssets getUnitAssets();

    @JsonProperty("is_dead")
    boolean isUnitIsDead();

    @JsonProperty("hp")
    int getHealthPoints();

    @JsonProperty("ap")
    int getActionPoints();

    @JsonProperty("str")
    public int getStrength();

    @JsonProperty("vit")
    public int getVitality();

    @JsonProperty("int")
    public int getIntelligence();

    @JsonProperty("dex")
    public int getDexterity();

    @JsonProperty("agi")
    public int getAgility();

}

