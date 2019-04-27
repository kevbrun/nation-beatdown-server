package ch.nation.rest.controller.impl;


import ch.nation.core.model.UserModel;
import ch.nation.rest.controller.interfaces.UserController;
import ch.nation.rest.services.impl.UserServiceImpl;
import ch.nation.rest.services.interf.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControllerImplResource extends AbstractResourceGameLogicController<UserModel,UserModel> implements UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private final UserService client;


    @Autowired
    public UserControllerImplResource(UserServiceImpl client) {
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

    /**
    @Override
    public ResponseEntity<List<UserModel>> getAllUsers() {


       Optional<ArrayList<UserModel>> resp= client.getAll();


       if(resp.isPresent()) return new ResponseEntity<>(resp.get(),HttpStatus.OK);

       return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Override
    public ResponseEntity<UserModel> createUser(UserModel requestBody) throws Exception {
        if(requestBody==null) throw new IllegalArgumentException("Request Body was null!");

       Optional<UserModel>  response = client.create(requestBody);

       if(!response.isPresent()) throw new Error("Could not create user internal error");


        return new ResponseEntity<>(response.get(),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserModel> updateUser(String uuid, UserModel requestBody) {

        if(uuid==null || requestBody==null )throw new IllegalArgumentException("Request Body was null!");

        requestBody.setId(uuid);
        Optional<UserModel> response = client.update(requestBody);

        if(response.isPresent()) return new ResponseEntity<>(response.get(),HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<UserModel> getUserByUuid(String uuid) {
        LOGGER.info(String.format("Received payload: %s",uuid));
        if(uuid==null ||uuid.isBlank()) throw new IllegalArgumentException("uuid is null!");

        Optional<UserModel> unitResponse = client.findById(uuid);

        if(unitResponse.isPresent() &&
                !unitResponse.isEmpty()) {

            LOGGER.info(String.format("Found user: %s",unitResponse.get().toString()));

            return new ResponseEntity<>(unitResponse.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

**/


}
