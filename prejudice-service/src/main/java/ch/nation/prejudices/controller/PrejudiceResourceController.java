package ch.nation.prejudices.controller;

import ch.nation.core.controller.AbstractNamedResourceGameLogicController;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.prejudices.AbstractPrejudiceDto;
import ch.nation.prejudices.service.PrejudiceResourceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PrejudiceResourceController extends AbstractNamedResourceGameLogicController<AbstractPrejudiceDto,AbstractPrejudiceDto> {


    public PrejudiceResourceController(PrejudiceResourceServiceImpl service) {
        super(service);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.getAll(projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity updatePatch(@RequestBody AbstractPrejudiceDto payload, @RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.updatePatch(payload,projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody AbstractPrejudiceDto object,@RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.create(object,projection);
    }
    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid,@RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.delete(uuid,projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.findById(uuid,projection);
    }


    @Override
    @RequestMapping(method = RequestMethod.GET,path="/search")
    public ResponseEntity findByName(@RequestParam("name") String name,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.findByName(name,projection);
    }
}

