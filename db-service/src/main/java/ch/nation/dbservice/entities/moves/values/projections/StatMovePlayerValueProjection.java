package ch.nation.dbservice.entities.moves.values.projections;

import com.fasterxml.jackson.annotation.JsonProperty;


//@Projection(name = "def",types = StatPlayerMoveValue.class)
public interface StatMovePlayerValueProjection extends BasePlayerMoveValueProjection {

    @JsonProperty("value")
    float getValue();
}
