package ch.nation.rest.services.interf;

import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;

import java.util.Optional;

public interface UserService  {

    Optional<UserDto> createAssociationWithNation(String userUuid, String nationUuid) throws Exception;
    Optional<NationDto> getNationAssociatedWithNation(String nationUuid);
}
