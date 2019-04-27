package ch.nation.rest.services.interf;

import ch.nation.core.model.UserModel;
import ch.nation.core.model.interf.GenericCRUDDao;
import ch.nation.core.model.interf.RestCRUDDao;

import java.util.ArrayList;

import java.util.Optional;

public interface UserService  extends GenericCRUDDao<UserModel,ArrayList<UserModel>,UserModel> {
}
