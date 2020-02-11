package ch.nation.dbservice.entities.game;


import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.game.projections.GameUserRuntimeInfoMaxProjection;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.TimestampProjection;
import ch.nation.dbservice.entities.user.GameCreatedUserProjection;
import ch.nation.dbservice.entities.user.MaxUserResponseProjection;
import ch.nation.dbservice.entities.user.UserMinResponseProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.UUID;

@Projection(name = "newgame", types = {Game.class})
public interface CreateGameResponseProjection extends  TimestampProjection, MinimizedEntityResponseProjection {

    @JsonProperty("round")
    public int getRound();
    @JsonProperty("status")
    public GameStatus getGameStatus();
    @JsonProperty("users")
    List<MaxUserResponseProjection> getUsers();
    @JsonProperty("current_player")
    public String getCurrentPlayerUuid();
    @JsonProperty("first_player")
    UUID getFirstPlayerUuid() ;
    @JsonProperty("next_player")
    UUID getNextPlayerUuid();
    @JsonProperty("runtimes")
    List<GameUserRuntimeInfoMaxProjection> getUserRuntimeInfos();


}
