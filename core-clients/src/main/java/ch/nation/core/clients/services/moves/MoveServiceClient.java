package ch.nation.core.clients.services.moves;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(contextId = "move-resource-service",value="nation-cloud-moves-service",decode404 = true, configuration = FeignClientConfig.class)
public interface MoveServiceClient extends BaseServiceRestClientInterface<BasePlayerMoveDto,BasePlayerMoveDto> {

    @RequestMapping(method = RequestMethod.GET,path="/search/runtime/{uuid}/round")
    ResponseEntity<List<AbstractPlayerMoveDto>> getMovesByGameRuntimeAndCooldownCounterGraterThan(@PathVariable("uuid")String gameRuntimeUuid, @RequestParam(value = "counter",required = false,defaultValue = "0") int counter, @RequestParam(value = "projection",required = false)QueryProjection projection);


    @RequestMapping(method = RequestMethod.GET,path="/search/runtime/{uuid}")
     ResponseEntity getAllMovesOfPlayerByGameRuntimeUUID(@PathVariable("uuid")String gameRuntimeUuid, @RequestParam(value = "unit",required = false)String unitUuid, @RequestParam(value = "projection",required = false)QueryProjection projection);


    @RequestMapping(method = RequestMethod.GET,path="/search/runtime/{uuid}/{caster-uuid}/{round}")
     ResponseEntity getAllMovesOfPlayerByGameRuntimeUUIDAndPlayerUuidAndRound(@PathVariable("uuid")String gameRuntimeUuid, @PathVariable("caster-uuid") String casterUuid, @PathVariable("round") int round, @RequestParam(value = "projection",required = false)QueryProjection projection);


    @RequestMapping(method = RequestMethod.GET,path="/search/runtime/{uuid}/count")
     int getCountOfMovesOfGameByGameRuntimeUuid(@PathVariable("uuid")String gameRuntimeUuid);

}
