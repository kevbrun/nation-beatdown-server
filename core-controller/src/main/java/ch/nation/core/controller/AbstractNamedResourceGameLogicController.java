package ch.nation.core.controller;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.interf.rest.FindByNameCRUDDao;
import ch.nation.core.services.AbstractNamedEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public abstract class AbstractNamedResourceGameLogicController<TResult extends NamedObjectAbstractDto, TInput extends NamedObjectAbstractDto> extends AbstractResourceGameLogicController<TResult, TInput> implements FindByNameCRUDDao<CharacterClassDto> {


    public AbstractNamedResourceGameLogicController(AbstractNamedEntityService service, HttpServletRequest request) {
        super(service, request);
    }


    public ResponseEntity findByName(@RequestParam("name") String name) {
       return findByName(name,QueryProjection.def);

    }

    public ResponseEntity findByIdentifier(@RequestParam("identifier") String identfier){
        return findByIdentifier(identfier);
    }

    public ResponseEntity findByIdentifier(@RequestParam("identifier") String identfier,@RequestParam(value = "projection",required = false)QueryProjection projection ){
        if(identfier==null ||identfier.isBlank()) throw new IllegalArgumentException("Parameter identifier is null or empty!");
        Optional<TResult> response;
        try {
            response = ((AbstractNamedEntityService)service).findByIdentifier(identfier,projection);

        } catch (NullPointerException ex) {
            LOGGER.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!response.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(response.get(), HttpStatus.OK);
    }

    public ResponseEntity findByName(@RequestParam("name") String name, @RequestParam(value = "projection",required = false)QueryProjection projection){
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is null or empty!");

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


    public ResponseEntity<Boolean> existsByName(@RequestParam("name") String name) {
        if (name == null || name.isEmpty()) return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        Optional<Boolean> response = ((AbstractNamedEntityService) service).existsByName(name);
        return new ResponseEntity<>(response.get(), HttpStatus.OK);


    }



}
