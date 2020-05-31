package ch.nation.core.clients.services.moves;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.dto.move.SkillPlayerMoveDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "skill-move-resource-service", value = "nation-cloud-moves-service", decode404 = true, configuration = FeignClientConfig.class)
public interface SkillMoveServiceClient extends BaseServiceRestClientInterface<SkillPlayerMoveDto, SkillPlayerMoveDto> {

}
