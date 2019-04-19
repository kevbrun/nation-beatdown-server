package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "nations",path = "nations")
public interface NationRepository extends PagingAndSortingRepository<Nation,Long> {

    Nation findOneByUuid(@Param("uuid") String uuid);



}

