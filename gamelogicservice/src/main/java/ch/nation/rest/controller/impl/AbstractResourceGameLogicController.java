package ch.nation.rest.controller.impl;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.interf.rest.RestCRUDDao;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

public abstract class AbstractResourceGameLogicController<TResult extends AbstractDto,TInput extends AbstractDto> implements RestCRUDDao<TInput> {
    protected final Logger LOGGER =LoggerFactory.getLogger(this.getClass());


    protected final AbstractGenericEntityService service;


    public AbstractResourceGameLogicController(AbstractGenericEntityService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity getAll() {
        Optional<ArrayList<TResult>> resp= service.getAll();
        if(resp.isPresent()) return new ResponseEntity<>(resp.get(),HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Override
    public ResponseEntity update(TInput payload) {
        if(payload==null )throw new IllegalArgumentException("Request Body was null!");
        if(payload.getId()==null )throw new IllegalArgumentException("Uuid was null!");
        Optional<TResult> response = service.update(payload);
        if(response.isPresent()) return new ResponseEntity<>(response.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity create( TInput object) throws Exception {
        if(object==null) throw new IllegalArgumentException("Request Body was null!");
        Optional<TResult>  response = service.create(object);
        if(!response.isPresent()) throw new Error("Could not create user internal error");
        return new ResponseEntity<>(response.get(),HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity delete(String uuid) throws Exception {
        if(uuid==null) throw new IllegalArgumentException("Request Body was null!");
        Optional<TResult> response = service.delete(uuid);
        if(!response.isPresent()) throw new Exception("Could not delete user!");
        return new ResponseEntity<>(response.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity findById(String uuid) {
        if(uuid==null || uuid.isBlank()) throw new IllegalArgumentException("Uuid is null or empty!");
        Optional<TResult> response = service.findById(uuid);
        if(!response.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response.get(),HttpStatus.OK);
    }
}
