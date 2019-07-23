package ch.nation.dbservice.entities.moves.values.projections;

import ch.nation.dbservice.entities.moves.values.StatPlayerMoveValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;


//@Projection(name = "def",types = StatPlayerMoveValue.class)
public interface StatMovePlayerValueProjection extends BasePlayerMoveValueProjection {

    @JsonProperty("value")
    float getValue();
}
