package ch.nation.core.clients.db.skills.effects;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.model.dto.skills.effects.TimeReversalSkillEffectDto;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "time-reversal-effects-db-service", value = "nation-database-service", path = "/skill-time-effects", decode404 = true, configuration = FeignClientConfig.class)
public interface DBTimeReversalSkillEffectRestClient extends DBRestServiceBaseInterface<TimeReversalSkillEffectDto, TimeReversalSkillEffectDto> {


    @Override
    default String getType() {
        return TimeReversalSkillEffectDto.class.getName();
    }
}
