package ch.nation.rest.clients.clazzes;

import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "classes-db-rest-service",value="nation-database-service",path = "/classes",decode404 = true, configuration = FeignClientConfig.class)
public interface DBCharacterClazzRestClient extends DBRestServiceBaseInterface<CharacterClassDto,CharacterClassDto> {
}
