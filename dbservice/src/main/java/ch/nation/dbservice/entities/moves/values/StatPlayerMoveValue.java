package ch.nation.dbservice.entities.moves.values;


import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@DiscriminatorValue("STAT")
@Entity(name="PLAYER_STAT_SKILL_VALUE")
public class StatPlayerMoveValue extends BasePlayerMoveValue implements IDiscrimantorValue {


    @JsonProperty("value")
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatPlayerMoveValue)) return false;
        if (!super.equals(o)) return false;
        StatPlayerMoveValue that = (StatPlayerMoveValue) o;
        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), value);
    }

    @Override
    public String toString() {
        return "StatPlayerMoveValue{" +
                "value=" + value +
                "} " + super.toString();
    }
}
