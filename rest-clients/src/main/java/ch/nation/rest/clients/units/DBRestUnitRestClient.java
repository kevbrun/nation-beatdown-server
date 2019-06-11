package ch.nation.rest.clients.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "units-db-service",value="nation-database-service",path = "/units",decode404 = true, configuration = FeignClientConfig.class)
public interface DBRestUnitRestClient extends DBRestServiceBaseInterface<UnitDto,UnitDto> {

    @Override
    default String getType() {
        return UnitDto.class.getName();
    }
}
