package ch.nation.core.model.dto.prejudices.triggers;

import ch.nation.core.model.dto.NamedObjectAbstractDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;


public abstract class AbstractPrejudiceTriggerDto extends NamedObjectAbstractDto {


    public AbstractPrejudiceTriggerDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "triggers";
    }
}
