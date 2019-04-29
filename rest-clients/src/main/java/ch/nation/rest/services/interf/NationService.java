package ch.nation.rest.services.interf;

import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface NationService {


    Optional<UserModel> getUser(String nationUUID);

    Optional<NationModel> createAssociationWithUser(String nationUuid,String userUri) throws Exception;


}
