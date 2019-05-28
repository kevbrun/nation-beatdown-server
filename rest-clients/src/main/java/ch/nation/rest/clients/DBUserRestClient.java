package ch.nation.rest.clients;


import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.config.FeignClientConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

@FeignClient(contextId = "user-db-rest-service",value="nation-database-service",path = "/users",decode404 = true, configuration = FeignClientConfig.class)
public interface DBUserRestClient  extends DBRestServiceBaseInterface<UserDto,UserDto> {


    @RequestMapping(method = RequestMethod.PUT, consumes = "text/uri-list", path="/{user_uuid}/nation")
    Resource<UserDto> associateWithNation(@PathVariable("user_uuid") String uuid, @RequestBody String nationUri);
    @RequestMapping(method = RequestMethod.GET, path="/{user_uuid}/nation")
    Resource<NationDto> getNation(@PathVariable("user_uuid")  String uuid);



}
