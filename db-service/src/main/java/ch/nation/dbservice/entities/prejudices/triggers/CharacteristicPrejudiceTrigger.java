package ch.nation.dbservice.entities.prejudices.triggers;

import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "CHARACTERISTIC_PREJUDICE_TRIGGER")
@DiscriminatorValue("CHAR")
public class CharacteristicPrejudiceTrigger extends BasePrejudiceTrigger implements IDiscrimantorValue {


    //TODO Set back to exported = true, check why it is not deserialized with max proj

    @Column(name = "characteristics")
    @JsonProperty("characteristics")
    @ManyToMany(fetch = FetchType.LAZY)
    @RestResource(path = "characteristics", rel = "characteristics", exported = false)
    private List<BaseCharacteristic> characteristics;

    public CharacteristicPrejudiceTrigger() {
        super();
        characteristics = new ArrayList<>();
    }


    public List<BaseCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<BaseCharacteristic> characteristics) {
        this.characteristics = characteristics;
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


    //CONNECTORS
    @Transactional
    public void addCharacteristic(BaseCharacteristic baseCharacteristic) {
        if (!getCharacteristics().contains(baseCharacteristic)) {
            getCharacteristics().add(baseCharacteristic);
            baseCharacteristic.addTrigger(this);

        }
    }

    @Transactional
    public void removeCharacteristic(BaseCharacteristic baseCharacteristic) {
        if (getCharacteristics().contains(baseCharacteristic)) {
            getCharacteristics().remove(baseCharacteristic);
            baseCharacteristic.removeTrigger(this);

        }
    }


}
