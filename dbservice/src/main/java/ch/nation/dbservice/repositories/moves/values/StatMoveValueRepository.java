package ch.nation.dbservice.repositories.moves.values;

import ch.nation.dbservice.entities.moves.values.StatMoveValue;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "moves-stat",path = "moves-stat")
public interface StatMoveValueRepository extends IPageableDao<StatMoveValue> {
}
