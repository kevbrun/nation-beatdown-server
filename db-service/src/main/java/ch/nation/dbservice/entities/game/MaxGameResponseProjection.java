package ch.nation.dbservice.entities.game;

import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.TimestampProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "max", types = {Game.class})
public interface MaxGameResponseProjection extends MinGameResponseProjection, TimestampProjection, MinimizedEntityResponseProjection {


    /**
     * @JsonProperty("round") public int getRound();
     * @JsonProperty("status") public GameStatus getGameStatus();
     * @JsonProperty("users") List<MaxUserResponseProjection> getUsers();
     * @JsonProperty("current_player") public UUID getCurrentPlayerUuid();
     * @JsonProperty("first_player") UUID getFirstPlayerUuid() ;
     * @JsonProperty("next_player") UUID getNextPlayerUuid();
     **/

    @JsonProperty("runtimes")
    List<GameUserRuntimeInfo> getUserRuntimeInfos();

}
