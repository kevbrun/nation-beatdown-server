package ch.nation.core.model.dto.characteristics;


import ch.nation.core.model.dto.NamedObjectAbstractDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({

        //BASE
        @JsonSubTypes.Type(value = SkillCharacteristicsDto.class, name = "SkillCharacteristic"),
        @JsonSubTypes.Type(value = StatCharacteristicsDto.class, name = "StatCharacteristic"),
        @JsonSubTypes.Type(value = BaseCharacteristicDto.class, name = "BaseCharacteristic")
})
public abstract class AbstractCharacteristicsDto extends NamedObjectAbstractDto {


    @Override
    public String ResourceCollectionName() {
        return "characteristics";
    }
}
