package ch.nation.rest.clients.prejudices.triggers;

import ch.nation.core.model.dto.prejudices.triggers.CharacteristicPrejudiceTriggerDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "triggers-char-db-service",value="nation-database-service",path = "/triggers-char",decode404 = true, configuration = FeignClientConfig.class)
public interface DBCharacteristicsTriggerRestClient extends DBRestServiceBaseInterface<CharacteristicPrejudiceTriggerDto,CharacteristicPrejudiceTriggerDto> {


    @Override
    default String getType() {
        return CharacteristicPrejudiceTriggerDto.class.getName();
    }
}
