package ch.nation.dbservice.entities.prejudices.triggers;

import ch.nation.dbservice.entities.characteristics.Characteristics;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name="CHARACTERISTIC_PREJUDICE_TRIGGER")
@DiscriminatorValue("CHAR")
public class CharacteristicPrejudiceTrigger extends PrejudiceTrigger{


    @Column(name="characteristics")
    @JsonProperty("characteristics")
    @ManyToMany
    @RestResource(path = "characteristics", rel="characteristics")
    private List<Characteristics> characteristics;

    public CharacteristicPrejudiceTrigger() {

    }

    public CharacteristicPrejudiceTrigger(List<Characteristics> characteristics) {
        this.characteristics = characteristics;
    }

    public List<Characteristics> getCharacteristics() {

        if( characteristics==null)  characteristics = new ArrayList<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacteristicPrejudiceTrigger)) return false;
        if (!super.equals(o)) return false;
        CharacteristicPrejudiceTrigger that = (CharacteristicPrejudiceTrigger) o;
        return Objects.equals(characteristics, that.characteristics);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), characteristics);
    }
}
