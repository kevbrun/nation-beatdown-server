package ch.nation.rest.clients;


import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import ch.nation.core.model.interf.RestCRUDDao;
import ch.nation.rest.config.FeignClientConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(contextId = "user-db-rest-service",value="nation-database-service",path = "/users",decode404 = true, configuration = FeignClientConfig.class)
public interface DBUserRestClient  extends DBRestServiceBaseInterface<Resource<UserModel>,Resources<UserModel>,UserModel> {




    /**



    @RequestMapping(method = RequestMethod.DELETE,path="/nation")
    Resources<NationModel> deleteAllNationEntities();

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/nations")
    Resource<NationModel> createNationEntity(@RequestBody NationModel entity);**/



}
