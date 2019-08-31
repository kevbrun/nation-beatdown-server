package ch.nation.core.clients.services.moves.values;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.dto.move.values.BasePlayerMoveValueDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "stat-move-value-resource-service",value="nation-cloud-move-value-service",decode404 = true, configuration = FeignClientConfig.class)
public interface StatMoveValueServiceClient extends BaseServiceRestClientInterface<BasePlayerMoveValueDto,BasePlayerMoveValueDto> {
}
