package ch.nation.dbservice.entities.Prejudices;

import ch.nation.dbservice.entities.Characteristics.Characteristics;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name="CHARACTERISTIC_PREJUDICE_TRIGGER")
@DiscriminatorValue("CHARACTER")
public class CharacteristicPrejudiceTrigger extends PrejudiceTrigger{


    @Column(name="characteristic")
    @JsonProperty("characteristic")
    @ManyToMany
    private List<Characteristics> characteristics;

    public CharacteristicPrejudiceTrigger() {
    }


    public List<Characteristics> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristics> characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "CharacteristicPrejudiceTrigger{" +
                "characteristics=" + characteristics +
                "} " + super.toString();
    }
}
