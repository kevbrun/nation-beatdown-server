package ch.nation.dbservice.entities.units;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public interface UnitBaseFields {


    @JsonProperty("class")
    CharacterClass getCharacterClass();
    @JsonProperty("state")
    UnitState getState();
    @JsonProperty("pos")
    EmeddableVector3 getPosition();
    @JsonProperty("assets")
    UnitAssets getUnitAssets();
    @Column(name="is_dead")
    public boolean isUnitIsDead();
}
