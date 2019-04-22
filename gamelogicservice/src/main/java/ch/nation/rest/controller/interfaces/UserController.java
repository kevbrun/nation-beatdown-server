package ch.nation.rest.controller.interfaces;

import ch.nation.core.model.UserModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface UserController {

    @RequestMapping(method = RequestMethod.GET,path = "/rest/api/v1/users")
    ResponseEntity<List<UserModel>> getAllUsers();


    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/rest/api/v1/users")
    ResponseEntity<UserModel> createUser(@RequestBody UserModel requestBody);

    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/rest/api/v1/users/{uuid}")
    ResponseEntity<UserModel> updateUser(@PathVariable("uuid") String uuid, @RequestBody UserModel requestBody);

    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/users/{uuid}")
    ResponseEntity<UserModel> getUserByUuid(@PathVariable("uuid") String uuid);


}
