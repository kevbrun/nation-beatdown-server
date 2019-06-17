package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.NamedObjectAbstractDto;

public abstract class AbstractPlayerMoveDto extends NamedObjectAbstractDto {

    @Override
    public String ResourceCollectionName() {
        return "move-stat";
    }
}
