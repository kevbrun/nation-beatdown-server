package ch.nation.rest.controller.impl;


import ch.nation.core.model.UserModel;
import ch.nation.rest.controller.interfaces.UserController;
import ch.nation.rest.services.interf.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerImpl implements UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    final UserService client;


    @Autowired
    public UserControllerImpl(UserService client) {
        this.client = client;
    }

    @Override
    public ResponseEntity<List<UserModel>> getAllUsers() {


       Optional<ArrayList<UserModel>> resp= client.getAll();


       if(resp.isPresent()) return new ResponseEntity<>(resp.get(),HttpStatus.OK);

       return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Override
    public ResponseEntity<UserModel> createUser(UserModel requestBody) {
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

        if(response.isPresent()) return new ResponseEntity<>(HttpStatus.OK);

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




}
