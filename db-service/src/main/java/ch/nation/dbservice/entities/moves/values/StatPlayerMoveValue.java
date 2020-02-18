package ch.nation.dbservice.entities.moves.values;


import ch.nation.core.model.Enums.StatModTarget;
import ch.nation.core.model.Enums.StatType;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@DiscriminatorValue("STAT")
@Entity(name = "PLAYER_STAT_SKILL_VALUE")
public class StatPlayerMoveValue extends BasePlayerMoveValue implements IDiscrimantorValue {


    @JsonProperty("applied_on_stat")
    @Enumerated(EnumType.STRING)
    private StatType appliedOn;


    @JsonProperty("value")
    private float value;


    public StatPlayerMoveValue() {
        super();
        appliedOn = StatType.NONE;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


    public StatType getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(StatType appliedOn) {
        this.appliedOn = appliedOn;
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
