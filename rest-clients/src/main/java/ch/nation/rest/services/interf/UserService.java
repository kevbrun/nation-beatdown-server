package ch.nation.rest.services.interf;

import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import ch.nation.core.model.interf.GenericCRUDDao;
import ch.nation.core.model.interf.RestCRUDDao;

import javax.swing.text.html.Option;
import java.util.ArrayList;

import java.util.Optional;

public interface UserService  {

    Optional<UserModel> createAssociationWithNation(String userUuid, String nationUuid) throws Exception;
    Optional<NationModel> getNationAssociatedWithNation(String nationUuid);
}
