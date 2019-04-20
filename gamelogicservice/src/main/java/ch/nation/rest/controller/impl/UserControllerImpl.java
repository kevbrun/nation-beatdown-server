package ch.nation.rest.controller.impl;


import ch.nation.core.model.UserModel;
import ch.nation.rest.clients.DBRestClient;
import ch.nation.rest.controller.interfaces.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    final DBRestClient client;


    @Autowired
    public UserControllerImpl(DBRestClient client) {
        this.client = client;
    }

    @Override
    public ResponseEntity<List<UserModel>> getAllUsers() {

        LOGGER.info("Try to get all users from database-service");
        Collection<UserModel> users = client.getAllUserEntities().getContent();
        List<UserModel> allUsersAsList = new ArrayList<>(users);


        if(allUsersAsList.size()==0){
            LOGGER.info("No users found in database!");
        }
        LOGGER.info(String.format("Found %d in database",allUsersAsList.size()));



        return  new ResponseEntity<>(allUsersAsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteAllUsers() {
        LOGGER.info("Try to delete all users");
        Collection<UserModel> users=   client.deleteAllUserEntities().getContent();
        List<UserModel> responseList = new ArrayList<>(users);

        if(responseList.size() ==0){LOGGER.info("Not deleted any users, because there aren't any!");}
        else{
            LOGGER.info(String.format("Deleted %d in database",responseList.size()));

        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserModel> createUser(UserModel requestBody) {



        UserModel response = null;
        if(validateUserModelBody(requestBody)){
          ResponseEntity<Resource<UserModel>> responseFromDB = client.createUserEntity(requestBody);

            Resource<UserModel> createdUser= responseFromDB.getBody();

          if(createdUser!=null){
              response =  createdUser.getContent();

              if(response==null ||response.getUuid()==null) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);





          }
        }

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    private boolean validateUserModelBody(UserModel requestBody){

        if(requestBody==null) throw new IllegalArgumentException("Request Body is null");
        LOGGER.info(String.format("Received payload: %s",requestBody.toString()));
//        if(!requestBody.isUuidValid()) throw new IllegalArgumentException("uuid is null or empty");
        if(!requestBody.isNameValid()) throw new IllegalArgumentException("name is null or empty");
        if(!requestBody.isPasswordValid()) throw new IllegalArgumentException("password is null or empty");
        return true;

    }
}
