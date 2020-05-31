package ch.nation.core.clients.services.skills;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "skill-effect-resource-service", value = "nation-cloud-skills-service", path = "/effects", decode404 = true, configuration = FeignClientConfig.class)
public interface SkillEffectServiceClient extends BaseServiceRestClientInterface<SkillEffectDto, SkillEffectDto> {
}
