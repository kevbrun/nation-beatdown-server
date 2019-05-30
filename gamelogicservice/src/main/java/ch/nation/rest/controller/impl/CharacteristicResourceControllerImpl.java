package ch.nation.rest.controller.impl;


import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.rest.controller.interfaces.CharacteristicResourceController;
import ch.nation.rest.services.impl.characteristics.CharacteristicServiceImpl;
import ch.nation.rest.services.impl.characteristics.CharacteristicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharacteristicResourceControllerImpl extends AbstractResourceGameLogicController<AbstractCharacteristicsDto,AbstractCharacteristicsDto> implements CharacteristicResourceController {

    private final CharacteristicService service;


    public CharacteristicResourceControllerImpl(CharacteristicServiceImpl service) {
        super(service);
        this.service =service;
    }


    @Override
    @RequestMapping(method = RequestMethod.GET,path = "/rest/api/v1/characteristics")
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/rest/api/v1/characteristics")
    public ResponseEntity update(@RequestBody AbstractCharacteristicsDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/rest/api/v1/characteristics")
    public ResponseEntity create(@RequestBody AbstractCharacteristicsDto object) throws Exception {
        return super.create(object);
    }


    @Override
    @RequestMapping(method = RequestMethod.DELETE,consumes = "application/json",path = "/rest/api/v1/characteristics/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/characteristics/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }

}
