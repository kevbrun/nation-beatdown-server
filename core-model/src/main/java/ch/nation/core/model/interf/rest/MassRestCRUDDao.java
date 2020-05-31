package ch.nation.core.model.interf.rest;

import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface MassRestCRUDDao<TInput> extends RestCRUDDao<TInput> {


    ResponseEntity batchUpdate(Collection<TInput> object);

    ResponseEntity batchDeletion(Collection<TInput> object);

}
