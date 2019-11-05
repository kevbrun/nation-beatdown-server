package ch.nation.dbservice.repositories.names;

import ch.nation.dbservice.entities.SimpleIdEntity;
import org.springframework.data.repository.CrudRepository;

public interface UnitFirstNameRepository extends CrudRepository<SimpleIdEntity,Long> {
}
