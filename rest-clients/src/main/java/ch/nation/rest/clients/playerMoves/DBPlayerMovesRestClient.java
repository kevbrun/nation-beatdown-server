package ch.nation.rest.clients.playerMoves;

import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(contextId = "game-moves-rest-service",value="nation-database-service",path = "/moves",decode404 = true, configuration = FeignClientConfig.class)
public interface DBPlayerMovesRestClient  extends DBRestServiceBaseInterface<BasePlayerMoveDto,BasePlayerMoveDto> {

    @Override
    default String getType() {
        return BasePlayerMoveDto.class.getName();
    }
}
