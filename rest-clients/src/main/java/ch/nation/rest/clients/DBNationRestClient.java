package ch.nation.rest.clients;

import ch.nation.core.model.dto.NationDto;
import ch.nation.core.model.dto.UserDto;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(contextId = "nation-db-rest-service",value="nation-database-service",path = "/nations",decode404 = true, configuration = FeignClientConfig.class)
public interface DBNationRestClient extends DBRestServiceBaseInterface<NationDto,NationDto> {



    @RequestMapping(method = RequestMethod.PUT, consumes = "text/uri-list", path="/{nation_uuid}/user")
    ResponseEntity<Resource<NationDto>> createAssociationWithUser(@PathVariable("nation_uuid") String uuid, @RequestBody String userUri);
    @RequestMapping(method = RequestMethod.GET, path="/{nation_uuid}/user")
    Resource<UserDto> getUserAssociatedWithNation(@PathVariable("nation_uuid")  String uuid);


}
