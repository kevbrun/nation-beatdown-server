package ch.nation.rest.services.impl.games;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.user.UserDto;

import java.util.Collection;
import java.util.Optional;

public interface GameResourceService {


    Optional<Collection<GameDto>> getGamesByUserAndStatus(String userUuid, GameStatus status, QueryProjection projection);
    Optional<Collection<GameDto>> getGamesByUserAndStatus(String userUuid, GameStatus status);
    Optional<Collection<GameDto>> getGamesByUserAndStatus(UserDto user, GameStatus status, QueryProjection projection);
    Optional<Collection<GameDto>> getGamesByUserAndStatus(UserDto user, GameStatus status);

}
