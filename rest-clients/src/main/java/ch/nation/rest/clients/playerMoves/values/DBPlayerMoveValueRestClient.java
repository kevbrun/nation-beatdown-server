package ch.nation.rest.clients.playerMoves.values;

import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "game-moves-value-rest-service",value="nation-database-service",path = "/base-values",decode404 = true, configuration = FeignClientConfig.class)
public interface DBPlayerMoveValueRestClient extends DBRestServiceBaseInterface<AbstractMoveSkillEffectValueDto,AbstractMoveSkillEffectValueDto> {

    @Override
    default String getType() {
        return AbstractMoveSkillEffectValueDto.class.getName();
    }
}
