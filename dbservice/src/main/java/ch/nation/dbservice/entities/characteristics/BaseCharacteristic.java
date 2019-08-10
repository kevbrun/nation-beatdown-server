package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.entities.user.Nation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name="CHARACTERISTICS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CHARACTERISTICS_TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BASE")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",visible = true)
@JsonSubTypes({

        //BASE
        @JsonSubTypes.Type(value = SkillCharacteristic.class, name = "SkillCharacteristic"),
        @JsonSubTypes.Type(value = StatCharacteristic.class, name = "StatCharacteristic"),
        @JsonSubTypes.Type(value = BaseCharacteristic.class, name = "BaseCharacteristic")
})


public  abstract class BaseCharacteristic extends NamedEntityBase implements IDiscrimantorValue {


  /**  @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
    @RestResource(path = "triggers", rel="triggers")
    private List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers;**/




    @RestResource(path="nations",rel="nations")
    @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
    private List<Nation> nations;



    public List<Nation> getNations() {
        if(nations==null) nations = new ArrayList<>();
        return nations;
    }

    public void setNations(List<Nation> nations) {
        this.nations = nations;
    }

 /**   public List<CharacteristicPrejudiceTrigger> getCharacteristicPrejudiceTriggers() {
        if(characteristicPrejudiceTriggers==null) characteristicPrejudiceTriggers = new ArrayList<>();
        return characteristicPrejudiceTriggers;
    }

    public void setCharacteristicPrejudiceTriggers(List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers) {
        this.characteristicPrejudiceTriggers = characteristicPrejudiceTriggers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseCharacteristic)) return false;
        if (!super.equals(o)) return false;
        BaseCharacteristic that = (BaseCharacteristic) o;
        return Objects.equals(characteristicPrejudiceTriggers, that.characteristicPrejudiceTriggers) &&
                Objects.equals(nations, that.nations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), characteristicPrejudiceTriggers, nations);
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

    }**/




}
