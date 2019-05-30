package ch.nation.dbservice.entities.prejudices;

import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.prejudices.Prejudice;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity(name="STAT_PREJUDICE")
@DiscriminatorValue("STAT")
public class StatPrejudice extends Prejudice {


    @Embedded
    @JsonProperty("delta")
    @Column(name = "delta")
    private StatBonusDelta delta;


    public StatPrejudice() {
    }

    public StatPrejudice(StatBonusDelta delta) {
        this.delta = delta;
    }

    public StatBonusDelta getDelta() {
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
}
