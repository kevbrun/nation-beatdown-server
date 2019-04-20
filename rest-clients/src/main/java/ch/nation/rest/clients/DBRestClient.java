package ch.nation.rest.clients;


import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="nation-database-service")
public interface DBRestClient {





    //DB-Users-Related
    @RequestMapping(method = RequestMethod.GET,path="/users")
    Resources<UserModel> getAllUserEntities();

    @RequestMapping(method = RequestMethod.DELETE,path="/users")
    Resources<UserModel> deleteAllUserEntities();

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/users")
    ResponseEntity<Resource<UserModel>> createUserEntity(UserModel entity);

    @RequestMapping(method = RequestMethod.GET,path = "/users/{userId}")
    Resources<UserModel> getUserById(@PathVariable("userId") long userId);

    @RequestMapping(method = RequestMethod.PUT, consumes = "text/uri-list", path="/users/{userId}/nation")
    Resource<NationModel> createNationAssociation(@PathVariable("userId") long userId, @RequestBody String nationId);

    @RequestMapping(method = RequestMethod.DELETE, consumes = "text/uri-list", path="/users/{userId}/nation")
    Resources<NationModel> deleteNationAssociation(@PathVariable("userId") long userId, @RequestBody String nationId);

    //DB-Nation-Related
    @RequestMapping(method = RequestMethod.GET,path="/nations")
    Resources<NationModel> getAllNationEntities();

    @RequestMapping(method = RequestMethod.GET,path = "/nations/{Id}")
    Resources<NationModel> getNationById(@PathVariable("Id") long userId);

    @RequestMapping(method = RequestMethod.DELETE,path="/nation")
    Resources<NationModel> deleteAllNationEntities();

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/nations")
    Resource<NationModel> createNationEntity(@RequestBody NationModel entity);



}
