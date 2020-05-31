package ch.nation.core.clients.db.skills;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.model.dto.skills.SkillDto;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "skill-db-service", value = "nation-database-service", path = "/skills", decode404 = true, configuration = FeignClientConfig.class)

public interface DBSkillRestClient extends DBRestServiceBaseInterface<SkillDto, SkillDto> {


    @Override
    default String getType() {
        return SkillDto.class.getName();
    }
}
