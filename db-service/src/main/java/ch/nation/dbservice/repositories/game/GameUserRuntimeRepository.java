package ch.nation.dbservice.repositories.game;

import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.user.NationMaxResponseProjection;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "user-runtimes",path = "user-runtimes",exported = true)
@Transactional
public interface GameUserRuntimeRepository extends IPageableDao<GameUserRuntimeInfo> {

    GameUserRuntimeInfo findByGame_IdAndPlayerUuid(@Param("gameUuid") UUID gameUuid, @Param("playerUuid") String playerUuid);



    boolean existsById(@Param("id") UUID id);
}