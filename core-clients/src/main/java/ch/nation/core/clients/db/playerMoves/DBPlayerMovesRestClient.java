package ch.nation.core.clients.db.playerMoves;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(contextId = "game-moves-rest-service", value = "nation-database-service", path = "/moves", decode404 = true, configuration = FeignClientConfig.class)
public interface DBPlayerMovesRestClient extends DBRestServiceBaseInterface<BasePlayerMoveDto, BasePlayerMoveDto> {

    @Override
    default String getType() {
        return BasePlayerMoveDto.class.getName();
    }


    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", path = "/search/findAllByGameInfo_IdAndCaster_IdAndRound")
    PagedResources<BasePlayerMoveDto> getAllMovesByGameRuntimeUuidAndCasterUuidAndRound(@RequestParam("runtime") String gameRuntimeUuid,
                                                                                        @RequestParam("caster") String casterUuid,
                                                                                        @RequestParam("round") int round,
                                                                                        @RequestParam(name = "projection", required = false)
                                                                                                QueryProjection projection);

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", path = "/search/findAllByGameInfo_Id")
    PagedResources<BasePlayerMoveDto> getAllMovesByGameRuntimeUuid(@RequestParam("runtime") String gameRuntimeUuid, @RequestParam(value = "page", required = false, defaultValue = "0") long page,
                                                                   @RequestParam(value = "size", required = false, defaultValue = "20") long size,
                                                                   @RequestParam(name = "projection", required = false)
                                                                           QueryProjection projection);


    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", path = "/search/countAllByGameInfo_Id")
    int getAllMovesPerPlayerByGameRuntimeUuid(@RequestParam("runtime") String gameRuntimeUuid);
}
