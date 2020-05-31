package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.NationRessource;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.entities.user.Nation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "CHARACTERISTICS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CHARACTERISTICS_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BASE")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({

        //BASE
        @JsonSubTypes.Type(value = SkillCharacteristic.class, name = "SkillCharacteristic"),
        @JsonSubTypes.Type(value = StatCharacteristic.class, name = "StatCharacteristic"),
        @JsonSubTypes.Type(value = BaseCharacteristic.class, name = "BaseCharacteristic")
})
//@AttributeOverride(name = "id", column = @Column(name = "characteristics_id"))

public abstract class BaseCharacteristic extends NationRessource implements IDiscrimantorValue {


    @ManyToMany(mappedBy = "characteristics", fetch = FetchType.EAGER)
    @JsonIgnore
    //EVTL JOIN TABLE?
    @RestResource(path = "triggers", rel = "triggers")
    private List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers;


    @RestResource(path = "nations", rel = "nations")
    //@ManyToMany(mappedBy = "characteristics")
    @ManyToMany
    @JsonIgnore
    @JoinColumn(name = "CHARACTERISTICS_id")
    private List<Nation> nations;


    public BaseCharacteristic() {
        super();
        if (characteristicPrejudiceTriggers == null) characteristicPrejudiceTriggers = new ArrayList<>();
        if (nations == null) nations = new ArrayList<>();


    }

    public List<Nation> getNations() {
        return nations;
    }

    public void setNations(List<Nation> nations) {
        this.nations = nations;
    }

    public List<CharacteristicPrejudiceTrigger> getCharacteristicPrejudiceTriggers() {
        return characteristicPrejudiceTriggers;
    }

    public void setCharacteristicPrejudiceTriggers(List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers) {
        LOGGER.debug("Execute custom setter");
        if (this.characteristicPrejudiceTriggers == null) {
            this.characteristicPrejudiceTriggers = characteristicPrejudiceTriggers;
        } else if (this.characteristicPrejudiceTriggers != characteristicPrejudiceTriggers) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.characteristicPrejudiceTriggers.clear();
            if (characteristicPrejudiceTriggers != null) {
                this.characteristicPrejudiceTriggers.addAll(characteristicPrejudiceTriggers);
            }
        }

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
    @Transactional
    public void addTrigger(CharacteristicPrejudiceTrigger trigger) {
        if (!getCharacteristicPrejudiceTriggers().contains(trigger)) {
            getCharacteristicPrejudiceTriggers().add(trigger);
            trigger.addCharacteristic(this);
        }

    }


    //Manuel
    @Transactional
    public void removeTrigger(CharacteristicPrejudiceTrigger trigger) {
        if (getCharacteristicPrejudiceTriggers().contains(trigger)) {
            getCharacteristicPrejudiceTriggers().remove(trigger);
            trigger.removeCharacteristic(this);
        }

    }


}
