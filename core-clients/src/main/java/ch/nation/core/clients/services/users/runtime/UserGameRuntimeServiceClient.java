package ch.nation.core.clients.services.users.runtime;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Component
@FeignClient(contextId = "user-runtime-resource-service",value="nation-cloud-user-runtime-service",decode404 = true, configuration = FeignClientConfig.class)
public interface UserGameRuntimeServiceClient extends BaseServiceRestClientInterface<GameUserRuntimeInfoDto,GameUserRuntimeInfoDto> {



    @RequestMapping(path = "/search/findByGame_IdAndPlayerUuid")
    ResponseEntity<GameUserRuntimeInfoDto> getUserRuntimeInfoByGameUuidAndByPlayerUuid(@RequestParam(value = "game_uuid")String gameUUid, @RequestParam(value = "player_uuid")String playerUUid, @RequestParam(value = "projection",required = false) QueryProjection projection);
}
