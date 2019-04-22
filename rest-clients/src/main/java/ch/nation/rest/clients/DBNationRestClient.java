package ch.nation.rest.clients;

import ch.nation.core.model.NationModel;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.ArrayList;

@FeignClient(contextId = "nation-db-rest-service",value="nation-database-service",path = "/nations",decode404 = true, configuration = FeignClientConfig.class)
public interface DBNationRestClient extends DBRestServiceBaseInterface<NationModel,ArrayList<NationModel>,NationModel> {



}
