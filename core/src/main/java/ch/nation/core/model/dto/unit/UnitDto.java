package ch.nation.core.model.dto.unit;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.position.Vector3Float;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitDto extends AbstractDto {


    @JsonProperty("class")
    private CharacterClassDto characterClass;

    @JsonProperty("state")

    private UnitState state;

    @JsonProperty("dead")
    private boolean isDead;

    // @Column(name="position")
    @JsonProperty("pos")

    private Vector3Float position;

    @JsonProperty("assets")
    private UnitAssetsDto unitAssets;


    public UnitDto() {
    }

    public UnitDto(CharacterClassDto characterClass, UnitState state, boolean isDead, Vector3Float position, UnitAssetsDto unitAssets) {
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

    public void setState(UnitState state) {
        this.state = state;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
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
