package ch.nation.rest.clients.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.clients.DBRestMassServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "units-mass-db-service",value="nation-database-service",path = "/units",decode404 = true, configuration = FeignClientConfig.class)
public interface DBMassRestUnitRestClient extends DBRestMassServiceBaseInterface<UnitDto,UnitDto> {
}
