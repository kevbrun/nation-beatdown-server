package ch.nation.dbservice.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;
@Converter(autoApply = true)
public class UuidConverter implements AttributeConverter<UUID, UUID> {

    @Override
    public UUID convertToDatabaseColumn(UUID attribute) {
        return attribute;
    }

    @Override
    public UUID convertToEntityAttribute(UUID dbData) {
        return dbData;
    }

}