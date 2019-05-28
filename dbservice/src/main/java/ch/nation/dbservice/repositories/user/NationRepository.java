package ch.nation.dbservice.repositories.user;

import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "nations",path = "nations")
@Transactional
public interface NationRepository extends IPageableDao<Nation> {



}

