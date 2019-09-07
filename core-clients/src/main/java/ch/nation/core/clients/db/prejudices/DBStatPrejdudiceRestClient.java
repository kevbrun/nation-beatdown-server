package ch.nation.core.clients.db.prejudices;

import ch.nation.core.model.dto.prejudices.StatPrejudiceDto;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "prejudices-stat-db-service",value="nation-database-service",path = "/prejudices-stat",decode404 = true, configuration = FeignClientConfig.class)
public interface DBStatPrejdudiceRestClient extends DBRestServiceBaseInterface<StatPrejudiceDto,StatPrejudiceDto> {


    @Override
    default String getType() {
        return StatPrejudiceDto.class.getName();
    }
}
