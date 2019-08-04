package ch.nation.rest.controller.impl;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.rest.services.impl.AbstractMassNamedEntityService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractMassNamedResourceGameLogicController<TResult extends NamedObjectAbstractDto, TInput extends NamedObjectAbstractDto> extends AbstractNamedResourceGameLogicController<TResult, TInput> {


    public AbstractMassNamedResourceGameLogicController(AbstractMassNamedEntityService service) {
        super(service);
    }


    public @ResponseBody
    ResponseEntity update(@RequestBody List<TInput> payload, QueryProjection projection) {

        if (payload.size() == 0) return ResponseEntity.notFound().build();
        if (payload.size() == 1) return update(payload.get(0));

        LOGGER.info("More than one item found. Start mass updatePatch");
        Optional<List<TResult>> response = ((AbstractMassNamedEntityService) service).batchUpdate(payload, projection);
        if (response.isPresent()) return new ResponseEntity<>(response.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }


    public @ResponseBody
    ResponseEntity update(@RequestBody List<TInput> payload) {
        return update(payload, QueryProjection.def);

    }

    public @ResponseBody
    ResponseEntity delete(@RequestBody Resources<TInput> payload, QueryProjection projection) {
        return delete(payload, projection);

    }

    public @ResponseBody
    ResponseEntity delete(@RequestBody Resources<TInput> payload) {

        if (payload.getContent().size() == 0) return ResponseEntity.notFound().build();

        List<TInput> inputList = new ArrayList<>(payload.getContent());
        if (payload.getContent().size() == 1) return update(inputList.get(0));

        LOGGER.info("More than one item found. Start mass updatePatch");
        Optional<Resource<Boolean>> response = ((AbstractMassNamedEntityService) service).batchDeletion(inputList);
        if (response.isPresent()) return new ResponseEntity<>(response.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
