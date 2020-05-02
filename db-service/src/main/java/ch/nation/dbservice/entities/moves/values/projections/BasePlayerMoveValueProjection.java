package ch.nation.dbservice.entities.moves.values.projections;

import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.units.Unit;
import com.fasterxml.jackson.annotation.JsonProperty;


//@Projection(name="def",types = {BasePlayerMoveValue.class, MoveSkillPlayerMoveValue.class,StatMovePlayerValueProjection.class})
public interface BasePlayerMoveValueProjection extends MinimizedEntityResponseProjection {

    @JsonProperty("seqId")
    int getSequenceIdentifier();

    @JsonProperty("target")
    Unit getTarget();
}

