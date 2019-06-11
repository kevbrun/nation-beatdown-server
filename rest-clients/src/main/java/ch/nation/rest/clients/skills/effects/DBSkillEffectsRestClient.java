package ch.nation.rest.clients.skills.effects;

import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(contextId = "skill-effects-db-service",value="nation-database-service",path = "/skill-effects",decode404 = true, configuration = FeignClientConfig.class)
@Component
public interface DBSkillEffectsRestClient extends DBRestServiceBaseInterface<SkillEffectDto,SkillEffectDto> {

    @Override
    default String getType() {
        return SkillEffectDto.class.getName();
    }
}
