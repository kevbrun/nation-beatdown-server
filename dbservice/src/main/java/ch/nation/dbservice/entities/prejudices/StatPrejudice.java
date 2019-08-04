package ch.nation.dbservice.entities.prejudices;

import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.prejudices.Prejudice;
import ch.nation.dbservice.entities.prejudices.triggers.PrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity(name="STAT_PREJUDICE")
@DiscriminatorValue("STAT")
public class StatPrejudice extends Prejudice {


    @Embedded
    @JsonProperty("delta")
    @Column(name = "delta")
    private StatBonusDelta delta;


    public StatPrejudice() {

    }

    public StatPrejudice(List<PrejudiceTrigger> prejudiceTriggers, PrejudiceOperator triggerOperation, StatBonusDelta delta) {
        super(prejudiceTriggers, triggerOperation);
        this.delta = delta;
    }

    public StatPrejudice(String name, String description, List<PrejudiceTrigger> prejudiceTriggers, PrejudiceOperator triggerOperation, StatBonusDelta delta) {
        super(name, description, prejudiceTriggers, triggerOperation);
        this.delta = delta;
    }

    public StatPrejudice(String name, String description, StatBonusDelta delta) {
        super(name, description);
        this.delta = delta;
    }

    public StatPrejudice(StatBonusDelta delta) {
        this.delta = delta;
    }

    public StatBonusDelta getDelta() {

        if(delta==null)delta = new StatBonusDelta();
        return delta;
    }

    public void setDelta(StatBonusDelta delta) {
        this.delta = delta;
    }


    @Override
    public String toString() {
        return "StatPrejudice{" +
                "delta=" + delta +
                "} " + super.toString();
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
}
