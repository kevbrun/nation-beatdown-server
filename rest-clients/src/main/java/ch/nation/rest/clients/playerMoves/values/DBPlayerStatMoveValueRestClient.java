package ch.nation.rest.clients.playerMoves.values;

import ch.nation.core.model.dto.move.values.StatSkillPlayerMoveSkillValueDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(contextId = "game-stat-value-rest-service",value="nation-database-service",path = "/stat-values",decode404 = true, configuration = FeignClientConfig.class)
public interface DBPlayerStatMoveValueRestClient extends DBRestServiceBaseInterface<StatSkillPlayerMoveSkillValueDto,StatSkillPlayerMoveSkillValueDto> {

    @Override
    default String getType() {
        return StatSkillPlayerMoveSkillValueDto.class.getName();
    }
}
