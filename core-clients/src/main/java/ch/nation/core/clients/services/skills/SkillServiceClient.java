package ch.nation.core.clients.services.skills;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.dto.skills.SkillDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "skill-resource-service", value = "nation-cloud-skills-service", decode404 = true, configuration = FeignClientConfig.class)
public interface SkillServiceClient extends BaseServiceRestClientInterface<SkillDto, SkillDto> {


}
