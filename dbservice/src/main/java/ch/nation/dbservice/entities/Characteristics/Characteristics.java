package ch.nation.dbservice.entities.Characteristics;

import ch.nation.dbservice.entities.NationEntityBase;
import ch.nation.dbservice.entities.Prejudices.CharacteristicPrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name="CHARACTERISTICS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CHARACTERISTICS_TYPE",discriminatorType = DiscriminatorType.STRING)
@RestResource(path = "characteristics")
public class Characteristics extends NationEntityBase {


    @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
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
