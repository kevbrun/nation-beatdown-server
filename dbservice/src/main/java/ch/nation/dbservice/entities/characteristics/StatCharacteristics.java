package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

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

    public StatCharacteristics(String name, String description, List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers, StatBonusDelta delta) {
        super(name, description, characteristicPrejudiceTriggers);
        this.delta = delta;
    }

    public StatCharacteristics(StatBonusDelta delta) {
        this.delta = delta;
    }

    public StatBonusDelta getDelta() {

        if(delta==null) delta = new StatBonusDelta();

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
