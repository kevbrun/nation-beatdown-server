package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MoveSkillValueDto.class, name = "MOVE"),
        @JsonSubTypes.Type(value = StatMoveValueDtoDto.class, name = "STAT"),
})
public abstract class AbstractMoveValueDto extends AbstractDto {








}
