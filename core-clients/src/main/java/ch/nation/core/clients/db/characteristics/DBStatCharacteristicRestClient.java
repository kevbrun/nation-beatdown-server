package ch.nation.core.clients.db.characteristics;

import ch.nation.core.model.dto.characteristics.StatCharacteristicsDto;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "characteristic-stat-db-rest-service",value="nation-database-service",path = "/characteristics-stat",decode404 = true, configuration = FeignClientConfig.class)
public interface DBStatCharacteristicRestClient extends DBRestServiceBaseInterface<StatCharacteristicsDto,StatCharacteristicsDto> {


    @Override
    default String getType() {
        return StatCharacteristicsDto.class.getName();
    }
}



