package ch.nation.rest.controller.impl;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.interf.rest.FindByNameCRUDDao;
import ch.nation.core.model.interf.rest.RestCRUDDao;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractResourceGameLogicController<TResult extends NamedObjectAbstractDto,TInput extends NamedObjectAbstractDto> implements RestCRUDDao<TInput> , FindByNameCRUDDao<CharacterClassDto> {
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
        Optional<Boolean> response = service.delete(uuid);
        if(!response.isPresent()) throw new Exception("Could not delete user!");
        return  ResponseEntity.ok(new Resource(Boolean.valueOf(response.get())));
    }

    @Override
    public ResponseEntity findById(String uuid) {
        if(uuid==null || uuid.isBlank()) throw new IllegalArgumentException("Uuid is null or empty!");
        Optional<TResult> response = service.findById(uuid);
        if(!response.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response.get(),HttpStatus.OK);
    }


    public ResponseEntity findByName(@RequestParam("name") String name)
    {
       if(name==null | name.isBlank()) throw new IllegalArgumentException("Name is null or empty!");
       Optional<TResult> response = service.findByName(name);
        if(!response.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(response.get(),HttpStatus.OK);

    }

    public ResponseEntity createAssociation(String uuid,List<AbstractDto> children) throws Exception {
        if(uuid==null || uuid.isBlank()) throw new IllegalArgumentException("Uuid is null or empty!");
        if(children.size()==0) return new ResponseEntity(HttpStatus.NO_CONTENT);

        Optional<TResult> result = service.createAssocation(uuid,children);

        return new ResponseEntity<>(result.get(),HttpStatus.OK);
    }




}
