package ch.nation.dbservice.entities.Characteristics;

import ch.nation.dbservice.entities.Bonus.StatBonusDelta;
import ch.nation.dbservice.entities.Clazzes.CharacterClass;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name="STAT_CHARACTERISTICS")
@DiscriminatorValue("STAT")
public class StatCharacteristics extends Characteristics {


    @Embedded
    @JsonProperty("delta")
    @Column(name = "delta")
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