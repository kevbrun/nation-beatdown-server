package ch.nation.rest.clients.skills.effects;

import ch.nation.core.model.dto.skills.effects.TimeReversalSkillEffectDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "time-reversal-effects-db-service",value="nation-database-service",path = "/skill-time-effects",decode404 = true, configuration = FeignClientConfig.class)
public interface DBTimeReversalSkillEffectRestClient extends DBRestServiceBaseInterface<TimeReversalSkillEffectDto,TimeReversalSkillEffectDto> {
}
