package ch.nation.rest.controller.impl;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.interf.rest.RestCRUDDao;
import ch.nation.rest.controller.interfaces.ChildrenNodeDao;
import ch.nation.rest.services.impl.AbstractEntityService;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AbstractResourceGameLogicController<TResult extends AbstractDto, TInput extends AbstractDto> implements RestCRUDDao<TInput>,ChildrenNodeDao {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    protected final AbstractEntityService service;

    public AbstractResourceGameLogicController(AbstractEntityService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity getAll() {
        return getAll(QueryProjection.def);
    }

    public ResponseEntity getAll(QueryProjection projection) {
        Optional<ArrayList<TResult>> resp = service.getAll(projection);
        if (resp.isPresent()) return new ResponseEntity<>(resp.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @Override
    public ResponseEntity update(TInput payload) {
        return update(payload, QueryProjection.def);

    }

    public ResponseEntity update(TInput payload, QueryProjection projection) {
        if (payload == null) throw new IllegalArgumentException("Request Body was null!");
        if (payload.getId() == null) throw new IllegalArgumentException("Uuid was null!");
        Optional<TResult> response = service.update(payload, projection);
        if (response.isPresent()) return new ResponseEntity<>(response.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity create(TInput object) throws Exception {
        return create(object, QueryProjection.def);
    }

    public ResponseEntity create(TInput object, QueryProjection projection) throws Exception {
        if (object == null) throw new IllegalArgumentException("Request Body was null!");
        Optional<TResult> response = service.create(object, projection);
        if (!response.isPresent()) throw new Error("Could not create user internal error");
        return new ResponseEntity<>(response.get(), HttpStatus.CREATED);

    }

    public ResponseEntity createWithChildren(Map<String,List<AbstractDto>> body, QueryProjection projection) throws Exception {

        if(!body.containsKey("parent")  ||  body.get("parent")==null ||body.get("parent").size()==0) throw new Exception("Could not create structure. Parent node does not exist!");
        if(!body.containsKey("children")  ||  body.get("children")==null || body.get("children").size()==0) throw new Exception("Could not create structure. Parent node does not exist!");

        List<AbstractDto> dto = (List<AbstractDto>) body.get("parent");

        Optional<TResult> response = service.createEntityWithChildren((NamedObjectAbstractDto) dto.get(0),body.get("children"),projection);
        if(!response.isPresent()) throw new Error("Could not create object internal error");
       return new ResponseEntity<>(response.get(), HttpStatus.CREATED);





    }

    @Override
    public ResponseEntity delete(String uuid) throws Exception {
        return delete(uuid, QueryProjection.def);
    }

    public ResponseEntity delete(String uuid, QueryProjection projection) throws Exception {
        if (uuid == null) throw new IllegalArgumentException("Request Body was null!");
        Optional<Boolean> response = service.delete(uuid, projection);
        if (!response.isPresent()) throw new Exception("Could not delete user!");
        return ResponseEntity.ok(new Resource(Boolean.valueOf(response.get())));

    }

    @Override
    public ResponseEntity findById(String uuid) {
        return findById(uuid, QueryProjection.def);
    }

    public ResponseEntity findById(String uuid, QueryProjection projection) {
        if (uuid == null || uuid.isBlank()) throw new IllegalArgumentException("Uuid is null or empty!");
        Optional<TResult> response = service.findById(uuid, projection);
        if (!response.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response.get(), HttpStatus.OK);


    }

    public ResponseEntity createAssociation(String uuid, List<AbstractDto> children, QueryProjection projection) throws Exception {

        if (uuid == null || uuid.isBlank()) throw new IllegalArgumentException("Uuid is null or empty!");
        if (children.size() == 0) return new ResponseEntity(HttpStatus.NO_CONTENT);
        Optional<TResult> result = service.createAssociation(uuid, children,projection);
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    public ResponseEntity createAssociation(String uuid, List<AbstractDto> children) throws Exception {
    return  createAssociation(uuid,children,QueryProjection.def);
}

    public ResponseEntity getChildrenNodesByResourceCollection(String uuid, String resourceCollection, QueryProjection projection) {
    if (uuid == null || uuid.isBlank()) throw new IllegalArgumentException("Uuid is null or empty!");
    if (resourceCollection == null || resourceCollection.isBlank())
        throw new IllegalArgumentException("resourceCollection is null or empty!");
    Optional<?> result = service.getChildrenEntites(uuid, resourceCollection,projection);
    if (!result.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return new ResponseEntity(result.get(), HttpStatus.OK);

}

    @Override
public ResponseEntity getChildrenNodesByResourceCollection(String uuid, String resourceCollection) {
    return getChildrenNodesByResourceCollection(uuid,resourceCollection,QueryProjection.def);
}
}
