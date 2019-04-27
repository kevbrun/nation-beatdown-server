package ch.nation.rest.clients;


import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import ch.nation.core.model.interf.RestCRUDDao;
import ch.nation.rest.config.FeignClientConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(contextId = "user-db-rest-service",value="nation-database-service",path = "/users",decode404 = true, configuration = FeignClientConfig.class)
public interface DBUserRestClient  extends DBRestServiceBaseInterface<Resource<UserModel>,Resources<UserModel>,UserModel> {


    @RequestMapping(method = RequestMethod.PUT, consumes = "text/uri-list", path="/{user_uuid}/nation")
    Resource<UserModel> associateWithNation(@PathVariable("user_uuid") String uuid, @RequestBody String nationUri);
    @RequestMapping(method = RequestMethod.GET, path="/{user_uuid}/nation")
    Resource<NationModel> getNation(@PathVariable("user_uuid")  String uuid);



}
