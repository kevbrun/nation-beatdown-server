package ch.nation.core.clients.db.characteristics;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.model.dto.characteristics.BaseCharacteristicDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


@Component
@FeignClient(contextId = "characteristic-db-rest-service", value = "nation-database-service", path = "/characteristics", decode404 = true, configuration = FeignClientConfig.class)
public interface DBBaseCharacteristicRestClient extends DBRestServiceBaseInterface<BaseCharacteristicDto, BaseCharacteristicDto> {

    @Override
    default String getType() {
        return BaseCharacteristicDto.class.getName();
    }
}
