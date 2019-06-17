package ch.nation.rest.controller.impl.users;


import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.controller.impl.AbstractMassResourceGameLogicController;
import ch.nation.rest.controller.interfaces.UserResourceController;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.users.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResourceControllerImpl extends AbstractMassResourceGameLogicController<UserDto,UserDto> implements UserResourceController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private final DBRestClientFactory factory;

    @Autowired
    public UserResourceControllerImpl(UserServiceImpl client, DBRestClientFactory factory) {
        super(client);
        this.factory = factory;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody UserDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/batch_update")
    public ResponseEntity update(@RequestBody  List<UserDto> payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/batch_delete")
    public ResponseEntity delete(@RequestBody Resources<UserDto> payload) {
        return super.delete(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody UserDto object) throws Exception {
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
    @RequestMapping(method = RequestMethod.PUT,path="/{uuid}")
    public ResponseEntity createAssociation(@PathVariable("uuid") String uuid,@RequestBody List<AbstractDto> children) throws Exception {
        return super.createAssociation(uuid, children);
    }


  /**  @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findByName(@RequestParam("name") String name) {
        return super.findByName(name);
    }**/
}
