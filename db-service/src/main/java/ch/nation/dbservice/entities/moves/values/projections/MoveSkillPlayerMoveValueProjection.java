package ch.nation.dbservice.entities.moves.values.projections;


import ch.nation.core.model.position.Vector3Int;
import com.fasterxml.jackson.annotation.JsonProperty;

//@Projection(name="def",types = MoveSkillPlayerMoveValue.class)
public interface MoveSkillPlayerMoveValueProjection extends BasePlayerMoveValueProjection {


    @JsonProperty("target_pos")
    Vector3Int getTargetPosition();

    @JsonProperty("source_pos")
    Vector3Int getSourcePosition();
}