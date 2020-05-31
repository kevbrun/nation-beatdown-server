package ch.nation.dbservice.entities.prejudices;

import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.dbservice.entities.NationRessource;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.prejudices.triggers.BasePrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity(name = "PREJUDICES")
@Table(name = "PREJUDICES")
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name = "PREJUDICE_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BASE")
/**@JsonTypeInfo( use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.EXISTING_PROPERTY,
property = "type",visible = true)
 @JsonSubTypes({

 //BASE
 @JsonSubTypes.Type(value = SkillPrejudice.class, name = "SkillPrejudice"),
 @JsonSubTypes.Type(value = StatPrejudice.class, name = "StatPrejudice"),
 @JsonSubTypes.Type(value = StatPrejudice.class, name = "BasePrejudice"),

 })**/
public class BasePrejudice extends NationRessource implements IDiscrimantorValue {

    @JsonProperty("triggers")
    @ManyToMany(fetch = FetchType.LAZY)
    @RestResource(path = "triggers", rel = "triggers")
    /**   @JoinTable(name="PREJUDICE_PREJUDICE_TRIGGERS", joinColumns=@JoinColumn(name="BASEPREJUDICE_ID"),
    inverseJoinColumns=@JoinColumn(name="BASEPREJUDICETRIGGER_ID"))**/
    private List<BasePrejudiceTrigger> prejudiceTriggers;

    @JsonProperty("operation")
    @Enumerated(EnumType.STRING)
    private PrejudiceOperator triggerOperation;

    /**
     * //  @RestResource(path = "nations", rel = "nations")
     * //@ManyToMany(mappedBy = "prejudices")
     * //@JsonIgnore
     * private List<Nation> nations;
     **/

    public BasePrejudice() {
        super();
        prejudiceTriggers = new ArrayList<>();
        //    nations  = new ArrayList<>();
    }

    public List<BasePrejudiceTrigger> getPrejudiceTriggers() {
        return prejudiceTriggers;
    }

    public void setPrejudiceTriggers(List<BasePrejudiceTrigger> prejudiceTriggers) {
        this.prejudiceTriggers = prejudiceTriggers;
    }

    public PrejudiceOperator getTriggerOperation() {
        return triggerOperation;
    }

    public void setTriggerOperation(PrejudiceOperator triggerOperation) {
        this.triggerOperation = triggerOperation;
    }

    /**
     * public List<Nation> getNations() {
     * return nations;
     * }
     * <p>
     * public void setNations(List<Nation> nations) {
     * this.nations = nations;
     * }
     **/

//Assication
    public void addTrigger(BasePrejudiceTrigger trigger) {
        if (!getPrejudiceTriggers().contains(trigger)) {
            getPrejudiceTriggers().add(trigger);
            trigger.addPrejudice(this);
        }

    }

    public void removeTrigger(BasePrejudiceTrigger trigger) {
        if (getPrejudiceTriggers().contains(trigger)) {
            getPrejudiceTriggers().remove(trigger);
            trigger.removeTrigger(this);
        }
    }

    @Override
    public String toString() {
        return "Prejudice{" +

                ", triggerOperation=" + triggerOperation +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePrejudice)) return false;
        if (!super.equals(o)) return false;
        BasePrejudice prejudice = (BasePrejudice) o;
        return Objects.equals(prejudiceTriggers, prejudice.prejudiceTriggers) &&
                triggerOperation == prejudice.triggerOperation;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), prejudiceTriggers, triggerOperation);
    }
}
