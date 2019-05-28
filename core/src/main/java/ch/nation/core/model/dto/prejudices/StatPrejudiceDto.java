package ch.nation.core.model.dto.prejudices;

import ch.nation.core.model.Enums.PrejudiceOperator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class StatPrejudiceDto extends AbstractPrejudiceDto {


    @JsonProperty("triggers")
    private List<AbstractPrejudiceTriggerDto> prejudiceTriggers;

    @JsonProperty("operation")
    private PrejudiceOperator triggerOperation;

    public StatPrejudiceDto(List<AbstractPrejudiceTriggerDto> prejudiceTriggers, PrejudiceOperator triggerOperation) {
        this.prejudiceTriggers = prejudiceTriggers;
        this.triggerOperation = triggerOperation;
    }

    public StatPrejudiceDto() {
    }

    public List<AbstractPrejudiceTriggerDto> getPrejudiceTriggers() {
        return prejudiceTriggers;
    }

    public void setPrejudiceTriggers(List<AbstractPrejudiceTriggerDto> prejudiceTriggers) {
        this.prejudiceTriggers = prejudiceTriggers;
    }

    public PrejudiceOperator getTriggerOperation() {
        return triggerOperation;
    }

    public void setTriggerOperation(PrejudiceOperator triggerOperation) {
        this.triggerOperation = triggerOperation;
    }

    @Override
    public String toString() {
        return "StatPrejudiceDto{" +
                "prejudiceTriggers=" + prejudiceTriggers +
                ", triggerOperation=" + triggerOperation +
                "} " + super.toString();
    }
}
