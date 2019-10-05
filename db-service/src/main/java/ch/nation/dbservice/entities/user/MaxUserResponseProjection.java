package ch.nation.dbservice.entities.user;

import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.projection.users.TimestampProjection;
import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;
import ch.nation.dbservice.entities.units.Unit;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "userProjection", types = User.class)
public interface MaxUserResponseProjection extends TimestampProjection,NamedClassesProjection {

    @JsonProperty("admin")
    public boolean isAdmin();


    @JsonProperty("nation")
    public Nation getNation();


    @JsonProperty("games")
    public List<Game> getGames();


    @JsonProperty("units")
    public List<Unit> getUnits();




}