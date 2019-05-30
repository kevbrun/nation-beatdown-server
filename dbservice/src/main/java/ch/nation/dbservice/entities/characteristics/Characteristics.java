package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Entity(name="CHARACTERISTICS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CHARACTERISTICS_TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BASE")
public  class Characteristics extends NamedEntityBase  {


    @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
    @RestResource(path = "triggers", rel="triggers")
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
