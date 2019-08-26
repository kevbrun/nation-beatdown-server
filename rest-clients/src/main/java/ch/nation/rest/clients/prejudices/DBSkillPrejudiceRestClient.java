package ch.nation.rest.clients.prejudices;

import ch.nation.core.model.dto.prejudices.AbstractPrejudiceDto;
import ch.nation.core.model.dto.prejudices.SkillPrejudiceDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(contextId = "prejudices-skill-db-service",value="nation-database-service",path = "/prejudices-skill",decode404 = true, configuration = FeignClientConfig.class)
public interface DBSkillPrejudiceRestClient extends DBRestServiceBaseInterface<SkillPrejudiceDto,SkillPrejudiceDto> {

    @Override
    default String getType() {
        return SkillPrejudiceDto.class.getName();
    }

}
