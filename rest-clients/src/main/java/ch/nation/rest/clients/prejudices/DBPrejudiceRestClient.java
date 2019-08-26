package ch.nation.rest.clients.prejudices;

import ch.nation.core.model.dto.prejudices.BasePrejudiceDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "prejudices-db-service",value="nation-database-service",path = "/prejudices",decode404 = true, configuration = FeignClientConfig.class)
public interface DBPrejudiceRestClient extends DBRestServiceBaseInterface<BasePrejudiceDto,BasePrejudiceDto> {

    @Override
    default String getType() {
        return BasePrejudiceDto.class.getName();
    }
}
