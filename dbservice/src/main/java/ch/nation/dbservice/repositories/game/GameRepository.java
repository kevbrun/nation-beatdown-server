package ch.nation.dbservice.repositories.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RepositoryRestResource(collectionResourceRel = "games",path = "games")
public interface GameRepository extends IPageableDao<Game> {



    Page<Game> findByUsersAndGameStatus(User user, GameStatus status, Pageable pageable);
}
