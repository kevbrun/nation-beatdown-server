package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.User.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "nations",path = "nations")
@Transactional
public interface NationRepository extends IPageableDao<Nation> {



}

