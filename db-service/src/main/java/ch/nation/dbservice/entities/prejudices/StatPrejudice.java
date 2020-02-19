package ch.nation.dbservice.entities.prejudices;

import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.prejudices.triggers.BasePrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity(name = "STAT_PREJUDICE")
@DiscriminatorValue("STAT")
public class StatPrejudice extends BasePrejudice implements IDiscrimantorValue {


    @Embedded
    @JsonProperty("delta")
    @Column(name = "delta")
    private StatBonusDelta delta;


    public StatPrejudice() {
        super();
        delta = new StatBonusDelta();

    }


    public StatPrejudice(StatBonusDelta delta) {
        this.delta = delta;
    }

    public StatBonusDelta getDelta() {

        if (delta == null) delta = new StatBonusDelta();
        return delta;
    }

    public void setDelta(StatBonusDelta delta) {
        this.delta = delta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatPrejudice)) return false;
        if (!super.equals(o)) return false;
        StatPrejudice that = (StatPrejudice) o;
        return Objects.equals(delta, that.delta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), delta);
    }

    @Override
    public String toString() {
        return "StatPrejudice{" +
                "delta=" + delta +
                '}';
    }
}
