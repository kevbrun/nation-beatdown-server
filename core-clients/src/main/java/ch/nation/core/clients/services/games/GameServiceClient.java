package ch.nation.core.clients.services.games;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Component
@FeignClient(contextId = "game-resource-service",value="nation-cloud-games-service",decode404 = true, configuration = FeignClientConfig.class)
public interface GameServiceClient extends BaseServiceRestClientInterface<GameDto,GameDto> {

    @RequestMapping(method = RequestMethod.POST,path = {"/{playerUuid}/{playerTwoUuid}"})
    ResponseEntity<GameDto> createGame(@PathVariable("playerUuid") String playerUuid,
                              @PathVariable(value = "playerTwoUuid", required = false) String playerTwoUuid,
                              @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.POST,path = {"/{playerUuid}"})
    ResponseEntity<GameDto> createGame(@PathVariable("playerUuid") String playerUuid,
                              @RequestParam(value = "projection", required = false) QueryProjection projection);


}
