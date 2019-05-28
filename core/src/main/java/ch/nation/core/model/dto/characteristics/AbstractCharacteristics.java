package ch.nation.core.model.dto.characteristics;


import ch.nation.core.model.dto.AbstractNationDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SkillCharacteristicsDto.class, name = "SKILL"),
        @JsonSubTypes.Type(value = SkillCharacteristicsDto.class, name = "CHAR"),
     })
public abstract class AbstractCharacteristics  extends AbstractNationDto {
}
