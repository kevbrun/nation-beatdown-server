package ch.nation.dbservice.repositories.moves.value;

import ch.nation.dbservice.entities.moves.values.MoveSkillPlayerMoveValue;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "values", path = "move-values"/**,excerptProjection = MoveSkillPlayerMoveValueProjection.class**/)
public interface PlayerMoveSkillEffectValueRepository extends IPageableDao<MoveSkillPlayerMoveValue> {
}

