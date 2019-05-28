package ch.nation.rest.services.interf;

import ch.nation.core.model.dto.NationDto;
import ch.nation.core.model.dto.UserDto;

import java.util.Optional;

public interface NationService {


    Optional<UserDto> getUser(String nationUUID);

    Optional<NationDto> createAssociationWithUser(String nationUuid, String userUri) throws Exception;


}
