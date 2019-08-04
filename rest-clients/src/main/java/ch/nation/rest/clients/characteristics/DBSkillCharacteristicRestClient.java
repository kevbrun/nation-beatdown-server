package ch.nation.rest.clients.characteristics;

import ch.nation.core.model.dto.characteristics.SkillCharacteristicsDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "characteristic-skill-db-rest-service",value="nation-database-service",path = "/characteristics-skill",decode404 = true, configuration = FeignClientConfig.class)
public interface DBSkillCharacteristicRestClient extends DBRestServiceBaseInterface<SkillCharacteristicsDto,SkillCharacteristicsDto> {

    @Override
    default String getType() {
        return SkillCharacteristicsDto.class.getName();
    }
}
