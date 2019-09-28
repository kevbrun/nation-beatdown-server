package ch.nation.dbservice.repositories.moves.value;

import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import ch.nation.dbservice.entities.moves.values.projections.BasePlayerMoveValueProjection;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "values",path = "base-values"/**,excerptProjection = BasePlayerMoveValueProjection.class**/)
public interface AbstractMoveSkillEffectValueRepository extends IPageableDao<BasePlayerMoveValue> {

}
