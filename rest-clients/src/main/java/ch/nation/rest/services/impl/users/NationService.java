package ch.nation.rest.services.impl.users;

import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;

import java.util.Optional;

public interface NationService {


    Optional<UserDto> getUser(String nationUUID);

    Optional<NationDto> createAssociationWithUser(String nationUuid, String userUri) throws Exception;


}
