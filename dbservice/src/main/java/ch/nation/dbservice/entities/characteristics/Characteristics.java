package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.NationEntityBase;
import ch.nation.dbservice.entities.prejudices.CharacteristicPrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Entity(name="CHARACTERISTICS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CHARACTERISTICS_TYPE",discriminatorType = DiscriminatorType.STRING)
@RestResource(path = "characteristics")
public class Characteristics extends NationEntityBase {


    @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
    @RestResource(path = "triggers", rel="prejudices_triggers")
    private List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers;

    public Characteristics() {
        super();
    }

    public Characteristics(String name) {
        super(name);
    }


    public List<CharacteristicPrejudiceTrigger> getCharacteristicPrejudiceTriggers() {
        return characteristicPrejudiceTriggers;
    }

    public void setCharacteristicPrejudiceTriggers(List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers) {
        this.characteristicPrejudiceTriggers = characteristicPrejudiceTriggers;
    }
}
