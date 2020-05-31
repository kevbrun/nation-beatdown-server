package ch.nation.dbservice.entities.prejudices.triggers;


import ch.nation.dbservice.entities.NationRessource;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.prejudices.BasePrejudice;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "PREJUDICE_TRIGGERS")
@Entity(name = "PREJUDICE_TRIGGERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TRIGGER_TYPE", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({

        //BASE
        @JsonSubTypes.Type(value = StatPrejudiceTrigger.class, name = "StatPrejudiceTrigger"),
        @JsonSubTypes.Type(value = CharacteristicPrejudiceTrigger.class, name = "CharacteristicPrejudiceTrigger"),
        @JsonSubTypes.Type(value = BasePrejudiceTrigger.class, name = "BasePrejudiceTrigger")
})
public abstract class BasePrejudiceTrigger extends NationRessource implements IDiscrimantorValue {

    @ManyToMany(mappedBy = "prejudiceTriggers", fetch = FetchType.EAGER)
    @RestResource(path = "prejudices", rel = "prejudices")
    @JsonProperty("prejudices")
    private List<BasePrejudice> prejudices;


    public BasePrejudiceTrigger() {
        super();
        if (prejudices == null) prejudices = new ArrayList<>();
    }


    public List<BasePrejudice> getPrejudices() {
        return prejudices;
    }

    public void setPrejudices(List<BasePrejudice> prejudices) {
        this.prejudices = prejudices;
    }

    @Override
    public String toString() {
        return "PrejudiceTrigger{" +
                "prejudices=" + prejudices +
                "} " + super.toString();
    }


    //Manual association func

    public void addPrejudice(BasePrejudice prejudice) {
        if (!getPrejudices().contains(prejudice)) {
            getPrejudices().add(prejudice);
            prejudice.addTrigger(this);
        }
    }

    public void removeTrigger(BasePrejudice prejudice) {
        if (getPrejudices().contains(prejudice)) {
            getPrejudices().remove(prejudice);
            prejudice.removeTrigger(this);
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof BasePrejudiceTrigger)) return false;
        if (!super.equals(o)) return false;
        BasePrejudiceTrigger that = (BasePrejudiceTrigger) o;
        return Objects.equals(prejudices, that.prejudices);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), prejudices);
    }
}
