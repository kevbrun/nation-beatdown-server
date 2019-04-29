package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.Nation;
import ch.nation.dbservice.entities.User;
import ch.nation.dbservice.projection.UserCompleteResponseProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "users",path = "users",excerptProjection = UserCompleteResponseProjection.class)
public interface UserRepository extends PagingAndSortingRepository<User,UUID> {


}
