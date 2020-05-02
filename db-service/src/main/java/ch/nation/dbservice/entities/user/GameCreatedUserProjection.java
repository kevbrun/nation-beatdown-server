package ch.nation.dbservice.entities.user;


import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;
import ch.nation.dbservice.entities.projection.users.TimestampProjection;
import ch.nation.dbservice.entities.units.UnitMaxResponseProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

//Only used for db scene initializer
@Projection(name = "created_game", types = User.class)
public interface GameCreatedUserProjection extends TimestampProjection, NamedClassesProjection, UserMinResponseProjection {

    @JsonProperty("nation")
    public Nation getNation();

    @JsonProperty("units")
    public List<UnitMaxResponseProjection> getUnits();
}
