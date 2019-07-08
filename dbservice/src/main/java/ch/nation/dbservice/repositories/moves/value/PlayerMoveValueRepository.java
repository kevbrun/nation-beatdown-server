package ch.nation.dbservice.repositories.moves.value;

import ch.nation.dbservice.entities.moves.values.AbstractBasePlayerMoveValue;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "values",path = "values")
public interface PlayerMoveValueRepository extends IPageableDao<AbstractBasePlayerMoveValue> {
}
