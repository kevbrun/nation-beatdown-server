package ch.nation.core.clients.db.skills.effects;

import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;

import ch.nation.core.clients.config.FeignClientConfig;
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
