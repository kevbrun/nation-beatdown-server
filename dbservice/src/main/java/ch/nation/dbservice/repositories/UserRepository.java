package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.User.User;
import ch.nation.dbservice.projection.UserCompleteResponseProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "users",path = "users",excerptProjection = UserCompleteResponseProjection.class)
public interface UserRepository extends IPageableDao<User> {


}
