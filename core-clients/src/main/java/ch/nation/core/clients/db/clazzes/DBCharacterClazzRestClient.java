package ch.nation.core.clients.db.clazzes;

import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "classes-db-rest-service",value="nation-database-service",path = "/classes",decode404 = true, configuration = FeignClientConfig.class)
public interface DBCharacterClazzRestClient extends DBRestServiceBaseInterface<CharacterClassDto,CharacterClassDto> {


    @Override
    default String getType() {
        return CharacterClassDto.class.getName();
    }
}
