package ch.nation.core.model.dto.prejudices.triggers;

import ch.nation.core.model.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value =CharacteristicPrejudiceTriggerDto.class, name = "CHAR"),
        @JsonSubTypes.Type(value = StatPrejudiceTriggerDto.class, name = "STAT"),
})
public abstract class AbstractPrejudiceTriggerDto extends AbstractDto {

    public AbstractPrejudiceTriggerDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "triggers";
    }
}
