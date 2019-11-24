package ch.nation.core.clients.db.playerMoves;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.move.SkillPlayerMoveDto;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(contextId = "game-moves-skill-rest-service",value="nation-database-service",path = "/moves-skill",decode404 = true, configuration = FeignClientConfig.class)

public interface DBSkillPlayerMoveRestClient extends DBRestServiceBaseInterface<SkillPlayerMoveDto, SkillPlayerMoveDto> {

    @Override
    default String getType() {
        return SkillPlayerMoveDto.class.getName();
    }


    @RequestMapping(method = RequestMethod.GET,consumes = "application/json",path="/search/findAllByGameInfo_IdAndCaster_IdAndRound")
    Resources<SkillPlayerMoveDto> getAllMovesByGameRuntimeUuidAndCasterUuidAndRound(@RequestParam("runtime")String gameRuntimeUuid,
                                                                                    @RequestParam("caster") String casterUuid,
                                                                                    @RequestParam("round") int round,
                                                                                    @RequestParam(name = "projection",required=false)
                                                                                           QueryProjection projection);

    @RequestMapping(method = RequestMethod.GET,consumes = "application/json",path="/search/findAllByGameInfo_Id")
    Resources<SkillPlayerMoveDto> getAllMovesByGameRuntimeUuid(@RequestParam("runtime")String gameRuntimeUuid,
                                                               @RequestParam(name = "projection",required=false)
                                                                      QueryProjection projection,@RequestParam(value = "sort",required = false,defaultValue = "updated,desc")String sort);

    @RequestMapping(method = RequestMethod.GET,consumes = "application/json",path="/search/findAllByGameInfo_IdAndCooldownCounterGreaterThan")
    Resources<SkillPlayerMoveDto> getAllMovesByCounterGreaterThan(@RequestParam("runtime")String gameRuntimeUuid,
                                                                  @RequestParam("counter") int counter,
                                                                  @RequestParam(name = "projection",required=false)
                                                                          QueryProjection projection);


}
