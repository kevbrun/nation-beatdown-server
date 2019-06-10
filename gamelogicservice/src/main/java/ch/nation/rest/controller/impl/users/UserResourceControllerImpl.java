package ch.nation.rest.controller.impl.users;


import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.controller.impl.AbstractMassResourceGameLogicController;
import ch.nation.rest.controller.interfaces.UserResourceController;
import ch.nation.rest.services.impl.users.UserServiceImpl;
import ch.nation.rest.services.impl.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserResourceControllerImpl extends AbstractMassResourceGameLogicController<UserDto,UserDto> implements UserResourceController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public UserResourceControllerImpl(UserServiceImpl client) {
        super(client);

    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/users")
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody UserDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/rest/api/v1/users/batch_update")
    public ResponseEntity update(@RequestBody  List<UserDto> payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/rest/api/v1/users/batch_delete")
    public ResponseEntity delete(@RequestBody List<UserDto> payload) {
        return super.delete(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/rest/api/v1/users")
    public ResponseEntity create(@RequestBody UserDto object) throws Exception {
        return super.create(object);
    }
    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/rest/api/v1/users/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/users/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }





}
