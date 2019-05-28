package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity(name="STAT_CHARACTERISTICS")
@DiscriminatorValue("STAT")
public class StatCharacteristics extends Characteristics {


    @Embedded
    @JsonProperty("delta")
    @Column(name = "delta")
    @RestResource(path = "bonus", rel="dbonus_delta")
    private StatBonusDelta delta;


    public StatCharacteristics() {
        super();
    }

    public StatCharacteristics(StatBonusDelta delta) {
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
        return "StatCharacteristics{" +
                "delta=" + delta +
                "} " + super.toString();
    }


}
