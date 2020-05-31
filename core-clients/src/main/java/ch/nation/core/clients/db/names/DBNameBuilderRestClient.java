package ch.nation.core.clients.db.names;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.model.dto.names.UnitCompleteNameDto;
import ch.nation.core.model.dto.names.UnitFirstNameDto;
import ch.nation.core.model.dto.names.UnitLastNameDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(contextId = "name-builder-rest-service", value = "nation-database-service", path = "/name-builder", decode404 = true, configuration = FeignClientConfig.class)
public interface DBNameBuilderRestClient {

    @RequestMapping(path = "/first-name/random", method = RequestMethod.GET)
    UnitFirstNameDto getRandomFirstName();


    @RequestMapping(path = "/last-name/random", method = RequestMethod.GET)
    UnitLastNameDto getRandomLastName();

    @RequestMapping(path = "/full-name/random", method = RequestMethod.GET)
    UnitCompleteNameDto getRandomFullName();

}
