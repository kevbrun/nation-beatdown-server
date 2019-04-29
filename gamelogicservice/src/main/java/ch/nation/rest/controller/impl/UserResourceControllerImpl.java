package ch.nation.rest.controller.impl;


import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import ch.nation.rest.controller.interfaces.UserResourceController;
import ch.nation.rest.services.impl.UserServiceImpl;
import ch.nation.rest.services.interf.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserResourceControllerImpl extends AbstractResourceGameLogicController<UserModel,UserModel> implements UserResourceController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private final UserService client;


    @Autowired
    public UserResourceControllerImpl(UserServiceImpl client) {
        super(client);
        this.client = client;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path = "/rest/api/v1/users")
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/rest/api/v1/users")
    public ResponseEntity update(@RequestBody UserModel payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/rest/api/v1/users")
    public ResponseEntity create(@RequestBody UserModel object) throws Exception {
        return super.create(object);
    }
    @Override
    @RequestMapping(method = RequestMethod.DELETE,consumes = "application/json",path = "/rest/api/v1/users/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/users/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }

    @Override
    public ResponseEntity associateWithNation(String uuid, NationModel nationUri) throws Exception {
       Optional<UserModel> model = client.createAssociationWithNation(uuid,nationUri.getId());

       if(!model.isPresent()){
           LOGGER.info("Could not create association!");
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

        return new ResponseEntity<>(model.get(),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity getNation(String uuid) {
        Optional<NationModel> nation = client.getNationAssociatedWithNation(uuid);
        if(!nation.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(nation.get(),HttpStatus.FOUND);
    }
}
