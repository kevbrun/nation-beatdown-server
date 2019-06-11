package ch.nation.rest.clients.prejudices.triggers;

import ch.nation.core.model.dto.prejudices.triggers.AbstractPrejudiceTriggerDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(contextId = "triggers-db-service",value="nation-database-service",path = "/triggers",decode404 = true, configuration = FeignClientConfig.class)

public interface DBTriggerRestClient extends DBRestServiceBaseInterface<AbstractPrejudiceTriggerDto,AbstractPrejudiceTriggerDto> {

    @Override
    default String getType() {
        return AbstractPrejudiceTriggerDto.class.getName();
    }
}
