package ch.nation.core.model.dto.move.values;

import ch.nation.core.model.dto.AbstractDto;

public abstract class AbstractMoveSkillEffectValueDto extends AbstractDto {
    @Override
    public String ResourceCollectionName() {
        return "values";
    }
}
