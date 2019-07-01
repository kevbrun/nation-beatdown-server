package ch.nation.dbservice.entities.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.user.UserMinResponseProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "min", types = {Game.class})
public interface MinGameResponseProjection extends MinimizedEntityResponseProjection
{
    @JsonProperty("round")
    public int getRound();
    @JsonProperty("status")
    public GameStatus getStatus();
    @JsonProperty("users")
    List<UserMinResponseProjection> getUsers();
}
