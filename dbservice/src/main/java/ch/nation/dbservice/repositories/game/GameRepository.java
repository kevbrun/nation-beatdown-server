package ch.nation.dbservice.repositories.game;

import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "games",path = "games")
public interface GameRepository extends IPageableDao<Game> {
}
