package ch.nation.dbservice.entities.prejudices;

import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.prejudices.triggers.PrejudiceTrigger;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity(name="PREJUDICES")
@Table(name = "PREJUDICES")
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name="PREJUDICE_TYPE",discriminatorType = DiscriminatorType.STRING)
public class Prejudice extends NamedEntityBase {

    @JsonProperty("triggers")
    @ManyToMany
    private List<PrejudiceTrigger> prejudiceTriggers;

    @JsonProperty("operation")
    @Enumerated(EnumType.STRING)
    private PrejudiceOperator triggerOperation;


    public Prejudice() {
        super();
    }

    public Prejudice(List<PrejudiceTrigger> prejudiceTriggers, PrejudiceOperator triggerOperation) {
        this.prejudiceTriggers = prejudiceTriggers;
        this.triggerOperation = triggerOperation;
    }

    public Prejudice(String name, String description, List<PrejudiceTrigger> prejudiceTriggers, PrejudiceOperator triggerOperation) {
        super(name, description);
        this.prejudiceTriggers = prejudiceTriggers;
        this.triggerOperation = triggerOperation;
    }

    public Prejudice(String name, String description) {
        super(name, description);
    }

    public List<PrejudiceTrigger> getPrejudiceTriggers() {

        if(prejudiceTriggers==null)  prejudiceTriggers = new ArrayList<>();

        return prejudiceTriggers;
    }

    public void setPrejudiceTriggers(List<PrejudiceTrigger> prejudiceTriggers) {
        this.prejudiceTriggers = prejudiceTriggers;
    }

    public PrejudiceOperator getTriggerOperation() {


        return triggerOperation;
    }

    public void setTriggerOperation(PrejudiceOperator triggerOperation) {
        this.triggerOperation = triggerOperation;
    }


    //Assication

    public void addTrigger(PrejudiceTrigger trigger){
        if(!getPrejudiceTriggers().contains(trigger)){
            getPrejudiceTriggers().add(trigger);
            trigger.addPrejudice(this);
        }

    }

    public void removeTrigger(PrejudiceTrigger trigger){
        if(getPrejudiceTriggers().contains(trigger)){
            getPrejudiceTriggers().remove(trigger);
            trigger.removeTrigger(this);
        }
    }

    @Override
    public String toString() {
        return "Prejudice{" +
                "prejudiceTriggers=" + prejudiceTriggers +
                ", triggerOperation=" + triggerOperation +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prejudice)) return false;
        if (!super.equals(o)) return false;
        Prejudice prejudice = (Prejudice) o;
        return Objects.equals(prejudiceTriggers, prejudice.prejudiceTriggers) &&
                triggerOperation == prejudice.triggerOperation;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), prejudiceTriggers, triggerOperation);
    }
}
