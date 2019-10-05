package ch.nation.dbservice.entities.moves.values.projections;


import ch.nation.core.model.position.Vector3;
import ch.nation.core.model.position.Vector3Int;
import ch.nation.dbservice.entities.moves.values.MoveSkillPlayerMoveValue;
import ch.nation.dbservice.entities.units.EmeddableVector3;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

//@Projection(name="def",types = MoveSkillPlayerMoveValue.class)
public interface MoveSkillPlayerMoveValueProjection extends BasePlayerMoveValueProjection{



    @JsonProperty("target_pos")
    Vector3Int getTargetPosition();
    @JsonProperty("source_pos")
    Vector3Int getSourcePosition();
}