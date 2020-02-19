package ch.nation.core.clients.db.playerMoves.values;

import ch.nation.core.model.dto.move.values.MoveSkillEffectPlayerMoveSkillValueDto;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "game-moves-move-value-rest-service", value = "nation-database-service", path = "/move-values", decode404 = true, configuration = FeignClientConfig.class)
public interface DBPlayerMoveMovementValueRestClient extends DBRestServiceBaseInterface<MoveSkillEffectPlayerMoveSkillValueDto, MoveSkillEffectPlayerMoveSkillValueDto> {

    @Override
    default String getType() {
        return MoveSkillEffectPlayerMoveSkillValueDto.class.getName();
    }
}
