package ch.nation.core.clients.db.units;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestMassServiceBaseInterface;
import ch.nation.core.model.dto.unit.UnitDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "units-mass-db-service", value = "nation-database-service", path = "/units", decode404 = true, configuration = FeignClientConfig.class)
public interface DBMassRestUnitRestClient extends DBRestMassServiceBaseInterface<UnitDto, UnitDto> {


    @Override
    default String getType() {
        return UnitDto.class.getName();
    }
}
