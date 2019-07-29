package ch.nation.rest.clients.playerMoves;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(contextId = "game-moves-rest-service",value="nation-database-service",path = "/moves",decode404 = true, configuration = FeignClientConfig.class)
public interface DBPlayerMovesRestClient  extends DBRestServiceBaseInterface<BasePlayerMoveDto,BasePlayerMoveDto> {

    @Override
    default String getType() {
        return BasePlayerMoveDto.class.getName();
    }


    @RequestMapping(method = RequestMethod.GET,consumes = "application/json",path="/search/findAllByGameInfo_IdAndCaster_IdAndRound")
    Resources<BasePlayerMoveDto> getAllMovesByGameRuntimeUuidAndCasterUuidAndRound(@RequestParam("runtime")String gameRuntimeUuid,
                                                                                   @RequestParam("caster") String casterUuid,
                                                                                   @RequestParam("round") int round,
                                                                                   @RequestParam(name = "projection",required=false)
                                                                                QueryProjection projection);

    @RequestMapping(method = RequestMethod.GET,consumes = "application/json",path="/search/findAllByGameInfo_Id")
    Resources<BasePlayerMoveDto> getAllMovesByGameRuntimeUuid(@RequestParam("runtime")String gameRuntimeUuid,
                                                                                   @RequestParam(name = "projection",required=false)
                                                                                           QueryProjection projection);
}
