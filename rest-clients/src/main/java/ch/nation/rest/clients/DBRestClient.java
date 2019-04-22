package ch.nation.rest.clients;


import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import ch.nation.rest.config.FeignClientConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(contextId = "user-db-rest-service",value="nation-database-service",decode404 = true, configuration = FeignClientConfig.class)
public interface DBRestClient {





    //DB-Users-Related
    @RequestMapping(method = RequestMethod.GET,path="/users")
    Resources<UserModel> getAllUserEntities();

     @RequestMapping(method = RequestMethod.DELETE,path="/users")
    Resources<UserModel> deleteAllUserEntities();

    @RequestMapping(method = RequestMethod.DELETE,path="/users/{uuid}")
    Resources<Void> deleteUser(@PathVariable("uuid") String uuid);

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/users")
    Resource<UserModel> createUserEntity(UserModel entity);

    @RequestMapping(method = RequestMethod.PATCH,consumes = "application/json",path = "/users/{uuid}")
    Resource<UserModel> updateUserEntity(@PathVariable("uuid") String uuid,@RequestBody UserModel entity);

    @RequestMapping(method = RequestMethod.GET,path = "/users/{uuid}")
    Resource<UserModel> getUserById(@PathVariable("uuid") String uuid);

    @RequestMapping(method = RequestMethod.PUT, consumes = "text/uri-list", path="/users/{uuid}/nation")
    Resource<NationModel> createNationAssociation(@PathVariable("uuid") String uuid, @RequestBody String nationId);

    @RequestMapping(method = RequestMethod.DELETE, consumes = "text/uri-list", path="/users/{uuid}/nation")
    Resources<NationModel> deleteNationAssociation(@PathVariable("uuid") String uuid, @RequestBody String nationId);

    //DB-Nation-Related
    @RequestMapping(method = RequestMethod.GET,path="/nations")
    Resources<NationModel> getAllNationEntities();

    @RequestMapping(method = RequestMethod.GET,path = "/nations/{uuid}")
    Resource<NationModel> getNationById(@PathVariable("uuid") String uuid);



    @RequestMapping(method = RequestMethod.DELETE,path="/nation")
    Resources<NationModel> deleteAllNationEntities();

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/nations")
    Resource<NationModel> createNationEntity(@RequestBody NationModel entity);



}
