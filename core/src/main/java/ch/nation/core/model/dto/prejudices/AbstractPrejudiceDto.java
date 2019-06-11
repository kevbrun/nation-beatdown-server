package ch.nation.core.model.dto.prejudices;


import ch.nation.core.model.dto.AbstractDto;

public abstract class AbstractPrejudiceDto extends AbstractDto {

    public AbstractPrejudiceDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "prejudices";
    }
}
