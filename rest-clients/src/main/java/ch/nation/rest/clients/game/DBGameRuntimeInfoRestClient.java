package ch.nation.rest.clients.game;

import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(contextId = "game-runtime-info-rest-service",value="nation-database-service",path = "/user-runtimes",decode404 = true, configuration = FeignClientConfig.class)
public interface DBGameRuntimeInfoRestClient extends DBRestServiceBaseInterface<GameUserRuntimeInfoDto,GameUserRuntimeInfoDto>  {

    @Override
    default String getType() {
        return GameUserRuntimeInfoDto.class.getName();
    }
}
