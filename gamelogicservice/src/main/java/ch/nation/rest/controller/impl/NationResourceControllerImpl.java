package ch.nation.rest.controller.impl;

import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.controller.interfaces.NationResourceControllerInterface;
import ch.nation.rest.services.impl.NationServiceImpl;
import ch.nation.rest.services.interf.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class NationResourceControllerImpl extends AbstractResourceGameLogicController<NationDto,NationDto> implements NationResourceControllerInterface {


    private final NationService service;

    @Autowired
    public NationResourceControllerImpl(NationServiceImpl service) {
        super(service);
        this.service = service;
    }


    @Override
    @RequestMapping(method = RequestMethod.GET,path = "/rest/api/v1/nations")
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/rest/api/v1/nations")
    public ResponseEntity update(@RequestBody NationDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/rest/api/v1/nations")
    public ResponseEntity create(@RequestBody NationDto object) throws Exception {
        return super.create(object);
    }


    @Override
    @RequestMapping(method = RequestMethod.DELETE,consumes = "application/json",path = "/rest/api/v1/nations/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/nations/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }

    @Override
    public ResponseEntity createAssociationWithUser(String uuid, UserDto userUri) throws Exception {
        Optional<NationDto> response = service.createAssociationWithUser(uuid,userUri.getId());

        if(response.isPresent()) return  new ResponseEntity<>(response.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity getUserAssociatedWithNation(String uuid) {
        Optional<UserDto> user = service.getUser(uuid);
        if(user.isPresent()) return new ResponseEntity<>(user.get(),HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
