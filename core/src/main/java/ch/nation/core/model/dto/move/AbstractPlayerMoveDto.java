package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.AbstractDto;

public abstract class AbstractPlayerMoveDto extends AbstractDto {

    @Override
    public String ResourceCollectionName() {
        return "move-stat";
    }
}
