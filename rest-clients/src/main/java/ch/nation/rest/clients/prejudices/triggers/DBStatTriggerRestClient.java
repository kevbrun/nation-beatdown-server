package ch.nation.rest.clients.prejudices.triggers;

import ch.nation.core.model.dto.prejudices.triggers.StatPrejudiceTriggerDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(contextId = "triggers-stat-db-service",value="nation-database-service",path = "/triggers-stat",decode404 = true, configuration = FeignClientConfig.class)
@Component
public interface DBStatTriggerRestClient extends DBRestServiceBaseInterface<StatPrejudiceTriggerDto,StatPrejudiceTriggerDto> {

    @Override
    default String getType() {
        return StatPrejudiceTriggerDto.class.getName();
    }
}
