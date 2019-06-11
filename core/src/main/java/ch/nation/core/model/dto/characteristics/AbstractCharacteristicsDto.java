package ch.nation.core.model.dto.characteristics;


import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.move.MoveSkillValueDto;
import ch.nation.core.model.dto.move.StatMoveValueDtoDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


public abstract class AbstractCharacteristicsDto extends AbstractDto {


     @Override
     public String ResourceCollectionName() {
          return "characteristics";
     }
}
