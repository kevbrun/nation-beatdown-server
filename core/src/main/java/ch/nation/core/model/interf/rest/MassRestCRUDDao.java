package ch.nation.core.model.interf.rest;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public interface MassRestCRUDDao<TInput> extends RestCRUDDao<TInput> {


    ResponseEntity batchUpdate(Collection<TInput> object);
    ResponseEntity batchDeletion(Collection<TInput> object);

}
