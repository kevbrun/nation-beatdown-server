package ch.nation.rest.clients.game;

import ch.nation.core.model.dto.game.GameDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "game-rest-service",value="nation-database-service",path = "/games",decode404 = true, configuration = FeignClientConfig.class)
public interface DBGameRestClient extends DBRestServiceBaseInterface<GameDto,GameDto> {

    @Override
    default String getType() {
        return GameDto.class.getName();
    }
}
