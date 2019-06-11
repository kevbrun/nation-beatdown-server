package ch.nation.rest.clients.characteristics;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


@Component
@FeignClient(contextId = "characteristic-db-rest-service",value="nation-database-service",path = "/characteristics",decode404 = true, configuration = FeignClientConfig.class)
public interface DBBaseCharacteristicRestClient extends DBRestServiceBaseInterface<AbstractCharacteristicsDto,AbstractCharacteristicsDto> {

    @Override
    default String getType() {
        return AbstractCharacteristicsDto.class.getName();
    }
}
