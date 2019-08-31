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

import java.util.List;

@Component
@FeignClient(contextId = "move-resource-service",value="nation-cloud-move-service",decode404 = true, configuration = FeignClientConfig.class)
public interface MoveServiceClient extends BaseServiceRestClientInterface<BasePlayerMoveDto,BasePlayerMoveDto> {

    ResponseEntity<List<AbstractPlayerMoveDto>> getMovesByGameRuntimeAndCooldownCounterGraterThan(String runtimeUUid, int round, QueryProjection projection);

}
