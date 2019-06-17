package ch.nation.dbservice.repositories.user;

import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.projection.users.CompleteUserObjectProjection;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "users",path = "users",excerptProjection = CompleteUserObjectProjection.class)
@Transactional
public interface UserRepository extends IPageableDao<User>, INamedObjectDao<User> {


}