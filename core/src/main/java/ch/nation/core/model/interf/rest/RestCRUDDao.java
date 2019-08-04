package ch.nation.core.model.interf.rest;


import ch.nation.core.model.interf.services.GenericCRUDQueryable;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface RestCRUDDao<TInput> {



    ResponseEntity getAll();
    ResponseEntity findById(String uuid);
    ResponseEntity create(TInput object) throws Exception;
    ResponseEntity delete(String uuid) throws Exception;
    ResponseEntity update(TInput payload);

}
