package ch.nation.dbservice.entities.moves.values.projections;

import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import ch.nation.dbservice.entities.moves.values.MoveSkillPlayerMoveValue;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.units.Unit;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;



//@Projection(name="def",types = {BasePlayerMoveValue.class, MoveSkillPlayerMoveValue.class,StatMovePlayerValueProjection.class})
public interface BasePlayerMoveValueProjection extends MinimizedEntityResponseProjection {


    @JsonProperty("target")
    Unit getTarget();
}

