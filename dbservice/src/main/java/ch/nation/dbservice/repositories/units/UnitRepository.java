package ch.nation.dbservice.repositories.units;

import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "units",path = "units")
@Transactional
public interface UnitRepository  extends IPageableDao<Unit> {
}
