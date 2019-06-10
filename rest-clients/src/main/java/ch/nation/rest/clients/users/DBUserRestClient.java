package ch.nation.rest.clients.users;


import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(contextId = "user-db-rest-service",value="nation-database-service",path = "/users",decode404 = true, configuration = FeignClientConfig.class)
public interface DBUserRestClient  extends DBRestServiceBaseInterface<UserDto,UserDto>{


}
