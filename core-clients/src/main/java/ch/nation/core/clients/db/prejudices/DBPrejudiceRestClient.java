package ch.nation.core.clients.db.prejudices;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.model.dto.prejudices.BasePrejudiceDto;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "prejudices-db-service", value = "nation-database-service", path = "/prejudices", decode404 = true, configuration = FeignClientConfig.class)
public interface DBPrejudiceRestClient extends DBRestServiceBaseInterface<BasePrejudiceDto, BasePrejudiceDto> {

    @Override
    default String getType() {
        return BasePrejudiceDto.class.getName();
    }
}
