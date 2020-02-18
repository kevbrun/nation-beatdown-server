package ch.nation.dbservice.repositories.moves.value;

import ch.nation.dbservice.entities.moves.values.StatPlayerMoveValue;
import ch.nation.dbservice.entities.moves.values.projections.StatMovePlayerValueProjection;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;


@Transactional
@RepositoryRestResource(collectionResourceRel = "values", path = "stat-values"/**,excerptProjection = StatMovePlayerValueProjection.class**/)
public interface StatPlayerMoveSkillEffectValueRepository extends IPageableDao<StatPlayerMoveValue> {
}
