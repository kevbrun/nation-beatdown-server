package ch.nation.core.model.interf.rest;


import org.springframework.http.ResponseEntity;

public interface RestCRUDDao<TInput> {


    ResponseEntity getAll();

    ResponseEntity findById(String uuid);

    ResponseEntity create(TInput object) throws Exception;

    ResponseEntity delete(String uuid) throws Exception;

    ResponseEntity updatePut(TInput payload);

    ResponseEntity updatePatch(TInput payload);

}
