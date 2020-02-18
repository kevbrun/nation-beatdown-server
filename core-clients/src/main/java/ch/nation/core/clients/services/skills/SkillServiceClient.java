package ch.nation.core.clients.services.skills;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.clients.services.BaseServiceRestClientInterface;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(contextId = "skill-resource-service", value = "nation-cloud-skills-service", decode404 = true, configuration = FeignClientConfig.class)
public interface SkillServiceClient extends BaseServiceRestClientInterface<SkillDto, SkillDto> {


}
