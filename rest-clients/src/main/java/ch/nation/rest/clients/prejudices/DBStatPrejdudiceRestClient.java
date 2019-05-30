package ch.nation.rest.clients.prejudices;

import ch.nation.core.model.dto.prejudices.StatPrejudiceDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "prejudices-stat-db-service",value="nation-database-service",path = "/prejudices-stat",decode404 = true, configuration = FeignClientConfig.class)
public interface DBStatPrejdudiceRestClient extends DBRestServiceBaseInterface<StatPrejudiceDto,StatPrejudiceDto> {




}
