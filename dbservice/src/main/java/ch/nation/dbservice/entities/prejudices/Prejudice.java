package ch.nation.dbservice.entities.prejudices;

import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.dbservice.entities.NamedEntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;


@Entity(name="PREJUDICES")
@Table(name = "PREJUDICES")
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name="PREJUDICE_TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("STAT")
public class Prejudice extends NamedEntityBase {

    @JsonProperty("triggers")
    @ManyToMany
    @RestResource(path="triggers",rel="prejudice-triggers")
    private List<PrejudiceTrigger> prejudiceTriggers;

    @JsonProperty("operation")
    @Enumerated(EnumType.STRING)
    private PrejudiceOperator triggerOperation;


    public Prejudice() {
    }

    public List<PrejudiceTrigger> getPrejudiceTriggers() {
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
        if(!prejudiceTriggers.contains(trigger)){
            prejudiceTriggers.add(trigger);
            trigger.addPrejudice(this);
        }

    }

    public void removeTrigger(PrejudiceTrigger trigger){
        if(prejudiceTriggers.contains(trigger)){
            prejudiceTriggers.remove(trigger);
            trigger.removeTrigger(this);
        }
    }
}
