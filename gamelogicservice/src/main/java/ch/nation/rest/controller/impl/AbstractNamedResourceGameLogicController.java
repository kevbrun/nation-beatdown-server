package ch.nation.rest.controller.impl;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.interf.rest.FindByNameCRUDDao;
import ch.nation.core.model.interf.rest.RestCRUDDao;
import ch.nation.rest.controller.interfaces.ChildrenNodeDao;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractNamedResourceGameLogicController<TResult extends NamedObjectAbstractDto, TInput extends NamedObjectAbstractDto> extends AbstractResourceGameLogicController<TResult, TInput> implements FindByNameCRUDDao<CharacterClassDto> {


    public AbstractNamedResourceGameLogicController(AbstractNamedEntityService service) {
        super(service);
    }


    public ResponseEntity findByName(@RequestParam("name") String name) {
       return findByName(name,QueryProjection.def);

    }

    public ResponseEntity findByName(@RequestParam("name") String name, @RequestParam(value = "projection",required = false)QueryProjection projection){
        if (name == null | name.isBlank()) throw new IllegalArgumentException("Name is null or empty!");

        Optional<TResult> response;
        try {
            response = ((AbstractNamedEntityService)service).findByName(name,projection);

        } catch (NullPointerException ex) {
            LOGGER.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!response.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(response.get(), HttpStatus.OK);
    }


}
