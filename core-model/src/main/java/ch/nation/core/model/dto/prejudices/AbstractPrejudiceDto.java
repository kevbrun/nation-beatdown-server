package ch.nation.core.model.dto.prejudices;


import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.characteristics.BaseCharacteristicDto;
import ch.nation.core.model.dto.characteristics.SkillCharacteristicsDto;
import ch.nation.core.model.dto.characteristics.StatCharacteristicsDto;
import ch.nation.core.model.dto.prejudices.triggers.AbstractPrejudiceTriggerDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({


        @JsonSubTypes.Type(value = BasePrejudiceDto.class, name = "BasePrejudice"),
        @JsonSubTypes.Type(value = SkillPrejudiceDto.class, name = "SkillPrejudice"),
        @JsonSubTypes.Type(value = StatPrejudiceDto.class, name = "StatPrejudice")
})
public abstract class AbstractPrejudiceDto extends NamedObjectAbstractDto {

    @JsonProperty("triggers")
    private List<AbstractPrejudiceTriggerDto> prejudiceTriggers;

    @JsonProperty("operation")
    private PrejudiceOperator triggerOperation;

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


    public AbstractPrejudiceDto() {
        super();
    }

    @Override
    public String ResourceCollectionName() {
        return "prejudices";
    }
}
