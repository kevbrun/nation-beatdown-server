package ch.nation.core.model.interf.rest;

import ch.nation.core.model.dto.NamedObjectAbstractDto;
import org.springframework.http.ResponseEntity;

public interface FindByNameCRUDDao<TResult extends NamedObjectAbstractDto> {

    ResponseEntity findByName(String name);
}
