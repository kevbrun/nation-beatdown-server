package ch.nation.dbservice.entities.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.user.UserMinResponseProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.UUID;

@Projection(name = "min", types = {Game.class})
public interface MinGameResponseProjection extends MinimizedEntityResponseProjection {
    @JsonProperty("round")
    public int getRound();

    @JsonProperty("status")
    public GameStatus getGameStatus();

    @JsonProperty("users")
    List<UserMinResponseProjection> getUsers();

    @JsonProperty("current_player")
    public String getCurrentPlayerUuid();

    @JsonProperty("first_player")
    UUID getFirstPlayerUuid();

    @JsonProperty("next_player")
    UUID getNextPlayerUuid();
}
