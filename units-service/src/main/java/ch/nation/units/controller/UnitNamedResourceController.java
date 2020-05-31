package ch.nation.units.controller;

import ch.nation.core.controller.AbstractMassNamedResourceGameLogicController;
import ch.nation.core.model.dto.names.UnitCompleteNameDto;
import ch.nation.core.model.dto.names.UnitFirstNameDto;
import ch.nation.core.model.dto.names.UnitLastNameDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.units.services.UnitResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
//@RequestMapping("/units")
public class UnitNamedResourceController extends AbstractMassNamedResourceGameLogicController<UnitDto, UnitDto> {


    @Autowired
    public UnitNamedResourceController(UnitResourceServiceImpl client, HttpServletRequest request) {
        super(client, request);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH, consumes = "application/json")
    public ResponseEntity updatePatch(@RequestBody UnitDto payload) {
        return super.updatePatch(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH, consumes = "application/json", path = "/batch_update")
    public ResponseEntity update(@RequestBody List<UnitDto> payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/batch_delete")
    public ResponseEntity delete(@RequestBody Resources<UnitDto> payload) {
        return super.delete(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity create(@RequestBody UnitDto object) throws Exception {
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

    @RequestMapping(path = "/first-name/random", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UnitFirstNameDto> getRandomFirstName() {
        return ((UnitResourceServiceImpl) service).getRandomFirstName();
    }


    @RequestMapping(path = "/last-name/random", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UnitLastNameDto> getRandomLastName() {
        return ((UnitResourceServiceImpl) service).getRandomLastName();
    }

    @RequestMapping(path = "/full-name/random", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UnitCompleteNameDto>> getRandomFullName(@RequestParam(value = "count", required = false, defaultValue = "1") int count) {
        return ((UnitResourceServiceImpl) service).getRandomFullNames(count);
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


    @RequestMapping(method = RequestMethod.GET, path = "/search/exists")
    public ResponseEntity<Boolean> exists(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "uuid", required = false) String uuid) {
        if (uuid != null && !uuid.isBlank()) return super.entityExists(uuid);
        if (name != null && !name.isBlank()) return super.existsByName(name);
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
}
