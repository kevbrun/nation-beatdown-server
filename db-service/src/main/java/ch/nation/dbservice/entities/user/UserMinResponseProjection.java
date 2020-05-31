package ch.nation.dbservice.entities.user;

import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "min", types = User.class)
public interface UserMinResponseProjection extends MinimizedEntityResponseProjection, NamedClassesProjection {


    @JsonProperty("role")
    String getRole();

    @JsonProperty("lost")
    public int getCountOfLoosedGames();

    @JsonProperty("won")
    public int getCountOfWonGames();

}
