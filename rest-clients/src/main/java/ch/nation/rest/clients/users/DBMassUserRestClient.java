package ch.nation.rest.clients.users;

import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.DBRestMassServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "user-mass-db-rest-service",value="nation-database-service",path = "/users",decode404 = true, configuration = FeignClientConfig.class)
public interface DBMassUserRestClient extends DBRestMassServiceBaseInterface<UserDto,UserDto> {
}
