package ch.nation.dbservice.repositories.moves;

import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.PreRemove;
import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@RepositoryRestResource(collectionResourceRel = "moves",path = "moves")
public interface PlayerMoveRepository extends IPageableDao<BasePlayerMove>, IMoveFind<BasePlayerMove> {





}
