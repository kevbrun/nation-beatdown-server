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
@DiscriminatorValue("CHARACTERISTICS_BASE")
public  class Characteristic extends NamedEntityBase  {


    @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
    @RestResource(path = "triggers", rel="triggers")
    private List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers;

    public Characteristic() {
        super();

    }


    public List<CharacteristicPrejudiceTrigger> getCharacteristicPrejudiceTriggers() {
        if(characteristicPrejudiceTriggers==null) characteristicPrejudiceTriggers = new ArrayList<>();
        return characteristicPrejudiceTriggers;
    }

    public void setCharacteristicPrejudiceTriggers(List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers) {
        this.characteristicPrejudiceTriggers = characteristicPrejudiceTriggers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Characteristic)) return false;
        if (!super.equals(o)) return false;
        Characteristic that = (Characteristic) o;
        return Objects.equals(characteristicPrejudiceTriggers, that.characteristicPrejudiceTriggers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), characteristicPrejudiceTriggers);
    }



    //Manuel
    public void addTrigger(CharacteristicPrejudiceTrigger trigger){
       if(!getCharacteristicPrejudiceTriggers().contains(trigger)){
           getCharacteristicPrejudiceTriggers().add(trigger);
           trigger.addCharacteristic(this);
       }

    }


    //Manuel
    public void removeTrigger(CharacteristicPrejudiceTrigger trigger){
        if(getCharacteristicPrejudiceTriggers().contains(trigger)){
            getCharacteristicPrejudiceTriggers().remove(trigger);
            trigger.removeCharacteristic(this);
        }

    }

}
