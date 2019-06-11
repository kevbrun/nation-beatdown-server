package ch.nation.dbservice.projection.users;

import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "userProjection", types = User.class)
public interface CompleteUserObjectProjection extends AbstractEntityProjection,NamedClassesProjection {

    @JsonProperty("admin")
    public boolean isAdmin();


    @JsonProperty("nation")
    public Nation getNation();


    @JsonProperty("games")
    public List<Game> getGames();


    @JsonProperty("units")
    public List<Unit> getUnits();




}