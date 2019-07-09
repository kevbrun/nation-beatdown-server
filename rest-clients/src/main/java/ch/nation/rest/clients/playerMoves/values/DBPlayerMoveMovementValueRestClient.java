package ch.nation.rest.clients.playerMoves.values;

import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.core.model.dto.move.values.MoveSkillEffectPlayerMoveSkillValueDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "game-moves-move-value-rest-service",value="nation-database-service",path = "/moves-values",decode404 = true, configuration = FeignClientConfig.class)
public interface DBPlayerMoveMovementValueRestClient extends DBRestServiceBaseInterface<MoveSkillEffectPlayerMoveSkillValueDto,MoveSkillEffectPlayerMoveSkillValueDto> {

    @Override
    default String getType() {
        return MoveSkillEffectPlayerMoveSkillValueDto.class.getName();
    }
}
