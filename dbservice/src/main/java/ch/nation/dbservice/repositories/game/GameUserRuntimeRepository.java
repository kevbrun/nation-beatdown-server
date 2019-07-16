package ch.nation.dbservice.repositories.game;

import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
import ch.nation.dbservice.entities.user.NationMaxResponseProjection;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "user-runtimes",path = "user-runtimes",exported = true)
@Transactional
public interface GameUserRuntimeRepository extends IPageableDao<GameUserRuntimeInfo> {
}
