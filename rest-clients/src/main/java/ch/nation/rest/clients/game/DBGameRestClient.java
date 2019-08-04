package ch.nation.rest.clients.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "game-rest-service",value="nation-database-service",path = "/games",decode404 = true, configuration = FeignClientConfig.class)
public interface DBGameRestClient extends DBRestServiceBaseInterface<GameDto,GameDto> {





    @Override
    default String getType() {
        return GameDto.class.getName();
    }




    @RequestMapping(method = RequestMethod.GET,path="/search/findByUsers_IdAndGameStatus")
    Resources<GameDto> GetGameByUserAndGameStatus(@RequestParam("uuid") String userUuid,@RequestParam("status") GameStatus status, @RequestParam(value = "projection",required = false) QueryProjection projection);




}
