package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity(name = "STAT_CHARACTERISTICS")
@DiscriminatorValue("STAT")
public class StatCharacteristic extends BaseCharacteristic implements IDiscrimantorValue {


    @Embedded
    @JsonProperty("delta")
    @Column(name = "delta")
    private StatBonusDelta delta;


    public StatCharacteristic() {
        super();


    }


    public StatCharacteristic(StatBonusDelta delta) {
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
    public String toString() {
        return "StatCharacteristic{" +
                "delta=" + delta +
                "} " + super.toString();
    }


}
