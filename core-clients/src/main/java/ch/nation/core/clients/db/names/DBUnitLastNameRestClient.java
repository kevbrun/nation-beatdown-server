package ch.nation.core.clients.db.names;


import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.model.dto.names.UnitLastNameDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(contextId = "last-name-rest-service", value = "nation-database-service", path = "/last-name", decode404 = true, configuration = FeignClientConfig.class)
public interface DBUnitLastNameRestClient {

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    Resource<UnitLastNameDto> findById(@PathVariable("id") long id);


}
