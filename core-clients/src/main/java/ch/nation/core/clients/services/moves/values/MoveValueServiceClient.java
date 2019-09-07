package ch.nation.core.clients.services.moves.values;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.core.model.dto.move.values.BasePlayerMoveValueDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "move-value-resource-service",value="nation-cloud-moves-service",path = "/values",decode404 = true, configuration = FeignClientConfig.class)
public interface MoveValueServiceClient extends BaseServiceRestClientInterface<AbstractMoveSkillEffectValueDto,AbstractMoveSkillEffectValueDto> {
}
