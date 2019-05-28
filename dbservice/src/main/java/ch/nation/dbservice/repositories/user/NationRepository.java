package ch.nation.dbservice.repositories.user;

import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.projection.INatioinExcerptProjection;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "nations",path = "nations",exported = false, excerptProjection = INatioinExcerptProjection.class)
@Transactional
public interface NationRepository extends IPageableDao<Nation> {



}

