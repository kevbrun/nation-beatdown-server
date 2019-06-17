package ch.nation.core.model.dto.prejudices;


import ch.nation.core.model.dto.NamedObjectAbstractDto;

public abstract class AbstractPrejudiceDto extends NamedObjectAbstractDto {

    public AbstractPrejudiceDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "prejudices";
    }
}
