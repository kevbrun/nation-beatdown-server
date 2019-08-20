package ch.nation.dbservice.repositories.moves;


import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.moves.SkillPlayerMove;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@RepositoryRestResource(collectionResourceRel = "moves",path = "moves-skill")
public interface SkillPlayerMoveRepository extends IPageableDao<SkillPlayerMove>, IMoveFind<SkillPlayerMove> {


    Iterable<SkillPlayerMove> findAllByGameInfo_IdAndCooldownCounterGreaterThan(@Param("runtime") UUID runtimeUuid, @Param("counter") int counter);


}
