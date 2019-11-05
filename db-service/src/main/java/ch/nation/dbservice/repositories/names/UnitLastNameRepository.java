package ch.nation.dbservice.repositories.names;

import ch.nation.dbservice.entities.names.UnitLastName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "names",path = "last-name")
public interface UnitLastNameRepository extends PagingAndSortingRepository<UnitLastName,Long> {


}
