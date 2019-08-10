package ch.nation.rest.controller.impl.characteristics;


import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.rest.controller.impl.AbstractNamedResourceGameLogicController;
import ch.nation.rest.controller.interfaces.CharacteristicResourceController;
import ch.nation.rest.services.impl.characteristics.BaseCharacteristicResourceServiceImpl;
import ch.nation.rest.services.impl.characteristics.CharacteristicResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characteristics")
public class CharacteristicNamedResourceControllerImpl extends AbstractNamedResourceGameLogicController<AbstractCharacteristicsDto,AbstractCharacteristicsDto> implements CharacteristicResourceController {

    private final CharacteristicResourceService service;


    public CharacteristicNamedResourceControllerImpl(BaseCharacteristicResourceServiceImpl service) {
        super(service);
        this.service =service;
    }


    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody AbstractCharacteristicsDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody AbstractCharacteristicsDto object) throws Exception {
        return super.create(object);
    }


    @Override
    @RequestMapping(method = RequestMethod.DELETE,consumes = "application/json",path = "/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }


}
