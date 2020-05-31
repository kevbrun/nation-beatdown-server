package ch.nation.core.clients.services.units;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.dto.unit.UnitDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(contextId = "units-resource-service", value = "nation-cloud-units-service", decode404 = true, configuration = FeignClientConfig.class)
public interface UnitServiceClient extends BaseServiceRestClientInterface<UnitDto, UnitDto> {
}
