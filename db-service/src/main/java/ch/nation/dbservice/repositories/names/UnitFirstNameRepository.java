package ch.nation.dbservice.repositories.names;

import ch.nation.dbservice.entities.SimpleIdEntity;
import ch.nation.dbservice.entities.names.UnitFirstName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "names",path = "first-name")
public interface UnitFirstNameRepository extends PagingAndSortingRepository<UnitFirstName,Long> {


}
