package ch.nation.dbservice.repositories.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "user-runtimes", path = "user-runtimes", exported = true)
@Transactional
public interface GameUserRuntimeRepository extends IPageableDao<GameUserRuntimeInfo> {

    GameUserRuntimeInfo findByGame_IdAndPlayerUuid(@Param("gameUuid") UUID gameUuid, @Param("playerUuid") String playerUuid);

    long countAllByPlayerUuidAndGame_GameStatus(@Param("playerUuid") String playerUuid, @Param("status") GameStatus status);

  // NOT USED ANYMORE long countAllByPlayerUuidAndGame_Winner(@Param("playerUuid") String playerUuid,@Param("playerUuid") String winnerUuid);

 //  NOT USED ANYMORE  long countAllByPlayerUuidAndNotGame_Winner(@Param("playerUuid") String playerUuid,@Param("playerUuid") String notWinnerUuid);

    boolean existsById(@Param("id") UUID id);
}
