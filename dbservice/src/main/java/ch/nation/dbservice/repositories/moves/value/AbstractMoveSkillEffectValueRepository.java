package ch.nation.dbservice.repositories.moves.value;

import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "values",path = "base-values")
public interface AbstractMoveSkillEffectValueRepository extends IPageableDao<BasePlayerMoveValue> {

}
