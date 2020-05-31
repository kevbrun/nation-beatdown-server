package ch.nation.core.clients.services.users;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "user-resource-service", value = "nation-cloud-users-service", decode404 = true, configuration = FeignClientConfig.class)
public interface UserServiceClient extends BaseServiceRestClientInterface<UserDto, UserDto> {
}
