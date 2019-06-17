package ch.nation.core.model.dto.characteristics;


import ch.nation.core.model.dto.NamedObjectAbstractDto;


public abstract class AbstractCharacteristicsDto extends NamedObjectAbstractDto {


     @Override
     public String ResourceCollectionName() {
          return "characteristics";
     }
}
