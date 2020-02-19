package ch.nation.dbservice.repositories.user;

import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.Resource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "users", path = "users"/**,excerptProjection = MaxUserResponseProjection.class**/)
@Transactional

public interface UserRepository extends IPageableDao<User>, INamedObjectDao<User> {

    @Override
    @Cacheable("allusers")
    Iterable<User> findAll();
}
