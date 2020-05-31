package ch.nation.clazz.controller;

import ch.nation.clazz.service.CharacterClazzResourceServiceImpl;
import ch.nation.core.controller.AbstractNamedResourceGameLogicController;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
//@RequestMapping("/classes")
public class CharacterClassRessourceController extends AbstractNamedResourceGameLogicController<CharacterClassDto, CharacterClassDto> {

    @Autowired
    public CharacterClassRessourceController(CharacterClazzResourceServiceImpl service, HttpServletRequest request) {
        super(service, request);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH, consumes = "application/json")
    public ResponseEntity updatePatch(@RequestBody CharacterClassDto payload) {
        return super.updatePatch(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity create(@RequestBody CharacterClassDto object) throws Exception {
        return super.create(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/{uuid}")
    public ResponseEntity delete(@PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid") String uuid) {
        return super.findById(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/search")
    public ResponseEntity findByName(@RequestParam("name") String name) {
        return super.findByName(name);
    }


    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/search/identifier")
    public ResponseEntity findByIdentifier(@RequestParam("identifier") String identfier, @RequestParam(value = "projection", required = false) QueryProjection projection) {
        return super.findByIdentifier(identfier, projection);
    }
}
