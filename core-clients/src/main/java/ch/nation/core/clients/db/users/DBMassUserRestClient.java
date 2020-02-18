package ch.nation.core.clients.db.users;

import ch.nation.core.clients.db.DBRestMassServiceBaseInterface;
import ch.nation.core.model.dto.user.UserDto;

import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "user-mass-db-rest-service", value = "nation-database-service", path = "/users", decode404 = true, configuration = FeignClientConfig.class)
public interface DBMassUserRestClient extends DBRestMassServiceBaseInterface<UserDto, UserDto> {


    @Override
    default String getType() {
        return UserDto.class.getName();
    }
}
