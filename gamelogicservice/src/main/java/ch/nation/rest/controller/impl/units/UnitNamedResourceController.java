package ch.nation.rest.controller.impl.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.controller.impl.AbstractMassNamedResourceGameLogicController;

import ch.nation.rest.services.impl.units.UnitResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/units")

public class UnitNamedResourceController extends AbstractMassNamedResourceGameLogicController<UnitDto,UnitDto> {



    @Autowired
    public UnitNamedResourceController(UnitResourceServiceImpl client) {
        super(client);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody UnitDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/batch_update")
    public ResponseEntity update(@RequestBody List<UnitDto> payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/batch_delete")
    public ResponseEntity delete(@RequestBody Resources<UnitDto> payload) {
        return super.delete(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody UnitDto object) throws Exception {
        return super.create(object);
    }
    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }



    @Override
    @RequestMapping(method = RequestMethod.GET,path="/search")
    public ResponseEntity findByName(@RequestParam("name") String name) {
        return super.findByName(name);
    }


    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection);
    }


    @Override
    @RequestMapping(method = RequestMethod.GET,path="/search/exists/{name}")
    public ResponseEntity<Boolean> existsByName(@PathVariable("name") String name) {
        return super.existsByName(name);
    }
}
