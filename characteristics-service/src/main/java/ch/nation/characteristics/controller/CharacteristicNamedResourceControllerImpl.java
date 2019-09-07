package ch.nation.characteristics.controller;



import ch.nation.core.controller.AbstractNamedResourceGameLogicController;
import ch.nation.core.controller.interfaces.CharacteristicResourceController;
import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.characteristics.services.BaseCharacteristicResourceServiceImpl;
import ch.nation.characteristics.services.CharacteristicResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/characteristics")
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
    public ResponseEntity updatePatch(@RequestBody AbstractCharacteristicsDto payload) {
        return super.updatePatch(payload);
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
