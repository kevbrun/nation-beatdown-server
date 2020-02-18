package ch.nation.dbservice.repositories.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@RepositoryRestResource(collectionResourceRel = "games", path = "games")
public interface GameRepository extends IPageableDao<Game> {


    Page<Game> findByUsers_IdAndGameStatus(@Param("uuid") UUID id, @Param("status") GameStatus gameStatus, Pageable pageable);


}
