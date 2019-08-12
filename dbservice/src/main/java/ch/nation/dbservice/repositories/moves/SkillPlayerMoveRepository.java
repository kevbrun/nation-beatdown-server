package ch.nation.dbservice.repositories.moves;


import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.moves.SkillPlayerMove;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "moves",path = "moves-skill")
public interface SkillPlayerMoveRepository extends IPageableDao<SkillPlayerMove>, IMoveFind<SkillPlayerMove> {
}
