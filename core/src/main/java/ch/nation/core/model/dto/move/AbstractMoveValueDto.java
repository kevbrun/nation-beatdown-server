package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.NamedObjectAbstractDto;


public abstract class AbstractMoveValueDto extends NamedObjectAbstractDto {

    @Override
    public String ResourceCollectionName() {
        return "moves";
    }
}
