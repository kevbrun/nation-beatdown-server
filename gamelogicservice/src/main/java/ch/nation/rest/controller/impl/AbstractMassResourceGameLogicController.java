package ch.nation.rest.controller.impl;

import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.rest.services.impl.AbstractMassGenericEntityService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractMassResourceGameLogicController<TResult extends NamedObjectAbstractDto,TInput extends NamedObjectAbstractDto> extends AbstractResourceGameLogicController<TResult,TInput>    {


    public AbstractMassResourceGameLogicController(AbstractMassGenericEntityService service) {
        super(service);
    }



    public @ResponseBody
    ResponseEntity update(@RequestBody List<TInput> payload) {

        if(payload.size()==0) return ResponseEntity.notFound().build();
        if(payload.size()==1) return update(payload.get(0));

        LOGGER.info("More than one item found. Start mass update");
        Optional<List<TResult>> response = ((AbstractMassGenericEntityService)service).batchUpdate(payload);
        if(response.isPresent()) return new ResponseEntity<>(response.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public @ResponseBody
    ResponseEntity delete(@RequestBody Resources<TInput> payload) {

        if(payload.getContent().size()==0) return ResponseEntity.notFound().build();

        List<TInput> inputList = new ArrayList<>(payload.getContent());
        if(payload.getContent().size()==1) return update(inputList.get(0));

        LOGGER.info("More than one item found. Start mass update");
        Optional<Resource<Boolean>> response = ((AbstractMassGenericEntityService)service).batchDeletion(inputList);
        if(response.isPresent()) return new ResponseEntity<>(response.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
