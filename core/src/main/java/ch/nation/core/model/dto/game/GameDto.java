package ch.nation.core.model.dto.game;

import ch.nation.core.model.dto.NamedObjectAbstractDto;

public class GameDto extends NamedObjectAbstractDto {
    @Override
    public String ResourceCollectionName() {
        return "games";
    }
}
