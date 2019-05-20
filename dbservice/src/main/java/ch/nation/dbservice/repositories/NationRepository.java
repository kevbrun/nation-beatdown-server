package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.User.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "nations",path = "nations")
public interface NationRepository extends PagingAndSortingRepository<Nation,UUID> {



}

