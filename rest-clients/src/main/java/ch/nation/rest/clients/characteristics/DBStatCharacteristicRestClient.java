package ch.nation.rest.clients.characteristics;

import ch.nation.core.model.dto.characteristics.StatCharacteristicsDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "characteristic-stat-db-rest-service",value="nation-database-service",path = "/characteristics-stat",decode404 = true, configuration = FeignClientConfig.class)
public interface DBStatCharacteristicRestClient extends DBRestServiceBaseInterface<StatCharacteristicsDto,StatCharacteristicsDto> {
}



