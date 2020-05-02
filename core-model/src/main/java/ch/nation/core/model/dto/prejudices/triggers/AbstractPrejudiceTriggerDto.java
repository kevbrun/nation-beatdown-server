package ch.nation.core.model.dto.prejudices.triggers;

import ch.nation.core.model.dto.NamedObjectAbstractDto;


public abstract class AbstractPrejudiceTriggerDto extends NamedObjectAbstractDto {


    public AbstractPrejudiceTriggerDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "triggers";
    }
}
