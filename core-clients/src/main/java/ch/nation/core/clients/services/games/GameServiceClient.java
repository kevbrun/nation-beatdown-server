package ch.nation.core.clients.services.games;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "game-resource-service",value="nation-cloud-game-service",decode404 = true, configuration = FeignClientConfig.class)
public interface GameServiceClient extends BaseServiceRestClientInterface<GameDto,GameDto> {


}
