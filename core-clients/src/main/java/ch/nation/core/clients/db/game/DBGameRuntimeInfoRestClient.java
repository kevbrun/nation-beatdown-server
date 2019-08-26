package ch.nation.core.clients.db.game;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(contextId = "game-runtime-info-rest-service",value="nation-database-service",path = "/user-runtimes",decode404 = true, configuration = FeignClientConfig.class)
public interface DBGameRuntimeInfoRestClient extends DBRestServiceBaseInterface<GameUserRuntimeInfoDto,GameUserRuntimeInfoDto>  {

    @Override
    default String getType() {
        return GameUserRuntimeInfoDto.class.getName();
    }


    @RequestMapping(method = RequestMethod.GET,path="/search/findByGame_IdAndPlayerUuid")
    GameUserRuntimeInfoDto findByGame_UuidAnAndPlayerUuid(@RequestParam("gameUuid") String gameUuid, @RequestParam("playerUuid") String playerUuid, @RequestParam(value="projection",required=false)QueryProjection projection);

}
