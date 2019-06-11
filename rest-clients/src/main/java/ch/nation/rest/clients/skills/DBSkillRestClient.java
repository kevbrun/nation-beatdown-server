package ch.nation.rest.clients.skills;

import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "skill-db-service",value="nation-database-service",path = "/skills",decode404 = true, configuration = FeignClientConfig.class)

public interface DBSkillRestClient extends DBRestServiceBaseInterface<SkillDto,SkillDto> {


    @Override
    default String getType() {
        return SkillDto.class.getName();
    }
}
