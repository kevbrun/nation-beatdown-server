package ch.nation.rest.controller.impl.clazzes;

import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.interf.rest.FindByNameCRUDDao;
import ch.nation.rest.controller.impl.AbstractResourceGameLogicController;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import ch.nation.rest.services.impl.clazzes.CharacterClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/classes")
public class CharacterClassRessourceController extends AbstractResourceGameLogicController<CharacterClassDto,CharacterClassDto>  {

    @Autowired
    public CharacterClassRessourceController(CharacterClazzServiceImpl service) {
        super(service);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody CharacterClassDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody CharacterClassDto object) throws Exception {
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

}
