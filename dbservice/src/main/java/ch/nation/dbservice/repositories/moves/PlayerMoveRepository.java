package ch.nation.dbservice.repositories.moves;

import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "moves",path = "moves")
public interface PlayerMoveRepository extends IPageableDao<BasePlayerMove> {
}
