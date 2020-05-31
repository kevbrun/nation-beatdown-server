package ch.nation.core.clients.db.playerMoves.values;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.model.dto.move.values.BasePlayerMoveValueDto;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "game-moves-value-rest-service", value = "nation-database-service", path = "/base-values", decode404 = true, configuration = FeignClientConfig.class)
public interface DBPlayerMoveValueRestClient extends DBRestServiceBaseInterface<BasePlayerMoveValueDto, BasePlayerMoveValueDto> {

    @Override
    default String getType() {
        return BasePlayerMoveValueDto.class.getName();
    }
}
