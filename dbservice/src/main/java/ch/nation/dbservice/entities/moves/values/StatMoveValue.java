package ch.nation.dbservice.entities.moves.values;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table(name="STAT_MOVE_VALUE")
@Entity(name="STAT_MOVE_VALUE")
@DiscriminatorValue("STAT")
public class StatMoveValue extends MoveValue{


    @Column(name="value")
    @JsonProperty("value")
    private float value;

    public StatMoveValue(float value) {
        this.value = value;
    }

    public StatMoveValue() {
        super();
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "StatMoveValue{" +
                "value=" + value +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatMoveValue)) return false;
        if (!super.equals(o)) return false;
        StatMoveValue that = (StatMoveValue) o;
        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), value);
    }
}
