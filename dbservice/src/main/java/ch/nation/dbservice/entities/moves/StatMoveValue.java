package ch.nation.dbservice.entities.moves;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


}
