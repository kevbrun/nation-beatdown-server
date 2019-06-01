package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.entities.prejudices.triggers.PrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    public Characteristics(List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers) {
        this.characteristicPrejudiceTriggers = characteristicPrejudiceTriggers;
    }

    public Characteristics(String name, String description, List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers) {
        super(name, description);
        this.characteristicPrejudiceTriggers = characteristicPrejudiceTriggers;
    }

    public List<CharacteristicPrejudiceTrigger> getCharacteristicPrejudiceTriggers() {
        if(characteristicPrejudiceTriggers==null)  characteristicPrejudiceTriggers = new ArrayList<>();
                return characteristicPrejudiceTriggers;
    }

    public void setCharacteristicPrejudiceTriggers(List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers) {
        this.characteristicPrejudiceTriggers = characteristicPrejudiceTriggers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Characteristics)) return false;
        if (!super.equals(o)) return false;
        Characteristics that = (Characteristics) o;
        return Objects.equals(characteristicPrejudiceTriggers, that.characteristicPrejudiceTriggers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), characteristicPrejudiceTriggers);
    }
}
