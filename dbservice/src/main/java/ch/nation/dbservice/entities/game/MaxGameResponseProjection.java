package ch.nation.dbservice.entities.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.projection.components.INameProjection;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.TimestampProjection;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "max", types = {Game.class})
public interface MaxGameResponseProjection extends TimestampProjection,MinimizedEntityResponseProjection {


    @JsonProperty("round")
    public int getRound();
    @JsonProperty("status")
    public GameStatus getStatus();
    @JsonProperty("users")
    List<User> getUsers();

}
