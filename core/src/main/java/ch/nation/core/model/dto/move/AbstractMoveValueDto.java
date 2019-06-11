package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


public abstract class AbstractMoveValueDto extends AbstractDto {

    @Override
    public String ResourceCollectionName() {
        return "moves";
    }
}
