package ch.nation.dbservice.entities.moves.values;


import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("STAT")
@Entity(name="PLAYER_STAT_SKILL_VALUE")
public class StatPlayerMoveValue extends AbstractBasePlayerMoveValue implements IDiscrimantorValue {


    @JsonProperty("value")
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
