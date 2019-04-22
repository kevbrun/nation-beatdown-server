package ch.nation.rest.services.impl;


import ch.nation.core.model.UserModel;
import ch.nation.rest.clients.DBRestClient;
import ch.nation.rest.services.interf.UserService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private final DBRestClient client;


    @Autowired
    public UserServiceImpl(DBRestClient client) {
        this.client = client;
    }


    @Override
    public Optional<List<UserModel>> getAll() {
        LOGGER.info("Try to get all users from database-service");
        Collection<UserModel> users = client.getAllUserEntities().getContent();
        List<UserModel> allUsersAsList = new ArrayList<>(users);


        if(allUsersAsList.size()==0){
            LOGGER.info("No users found in database!");
            return Optional.empty();
        }
        LOGGER.info(String.format("Found %d in database",allUsersAsList.size()));
        return Optional.of(allUsersAsList);
    }

    @Override
    public Optional<UserModel> findById(String uuid) {
        LOGGER.info(String.format("Try to get db user | uuid : %s",uuid));

        if(uuid!=null && !uuid.isBlank()) {


            Resource<UserModel> response=   client.getUserById(uuid);


            if(response!=null){
                LOGGER.info(String.format("Found db user | uuid : %s",uuid));

                UserModel model = response.getContent();
                return Optional.of(model);
            }

        }
        LOGGER.info(String.format("DB User Not found ! | uuid : %s",uuid));

        return Optional.empty();
    }


      @Override
    public Optional<UserModel> create(UserModel object) {
        LOGGER.info(String.format("Creating user in db | Payload: %s",object.toString()));

        if(validateNonExistingUserModelBody(object)) {

            if (!checkIfUserExistsInDB(object.getId())) {
                Resource<UserModel> createdUser = client.createUserEntity(object);
                if (createdUser != null && createdUser.getContent() != null) {
                    LOGGER.info(String.format("User in db CREATED!| Payload: %s", object.toString()));

                    UserModel model = createdUser.getContent();
                    return Optional.of(model);
                }

            }else{
                throw new IllegalArgumentException(String.format("User with name %s already exists",object.getName()));
            }
        }

        LOGGER.info(String.format("User in db NOT CREATED!| Payload: %s",object.toString()));

        return Optional.empty();
    }

    @Override
    public Optional<UserModel> delete(UserModel object) {
        LOGGER.info(String.format("Deleting user in db | Payload: %s",object.toString()));

        if(validateExistingUserModelBody(object)){


        Resources<Void> deleted=    client.deleteUser(object.getId());


        LOGGER.info("DELETED!");
            return Optional.of(object);

        }



        return Optional.empty();
    }

    @Override
    public Optional<UserModel> update(UserModel object) {

        if(validateExistingUserModelBody(object) && checkIfUserExistsInDB(object.getId())){

            String uuid = object.getId();
            object.setId(null);


            Resource<UserModel> updatedEntry= client.updateUserEntity(uuid,object);

            if(updatedEntry.getContent()!=null){
                LOGGER.info(String.format("Updated %s",updatedEntry.getContent().toString()));
                return Optional.of(updatedEntry.getContent());
            }

        }




        return Optional.empty();
    }

    private boolean validateExistingUserModelBody(UserModel requestBody){

     //   if throw new IllegalArgumentException("uuid is null or empty");
        return true;

    }

    private boolean validateNonExistingUserModelBody(UserModel requestBody){
        if(requestBody==null) throw new IllegalArgumentException("Request Body is null");
        LOGGER.info(String.format("Received payload: %s",requestBody.toString()));
        if(!requestBody.isNameValid()) throw new IllegalArgumentException("name is null or empty");
        if(!requestBody.isPasswordValid()) throw new IllegalArgumentException("password is null or empty");
        return true;
    }

    private boolean checkIfUserExistsInDB(String uuid){
      Optional<UserModel> response =  findById(uuid);

      if(response.isPresent()) return true;

      return false;
    }
}
