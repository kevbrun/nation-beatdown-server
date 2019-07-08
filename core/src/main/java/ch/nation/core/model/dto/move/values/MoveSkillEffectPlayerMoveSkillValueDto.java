package ch.nation.core.model.dto.move.values;

import ch.nation.core.model.position.Vector3Float;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoveSkillEffectPlayerMoveSkillValueDto extends AbstractMoveSkillEffectValueDto {


    @JsonProperty("source")
    private Vector3Float sourcePosition;

    @JsonProperty("target")
    private Vector3Float targetPosition;


    public Vector3Float getSourcePosition() {
        return sourcePosition;
    }

    public void setSourcePosition(Vector3Float sourcePosition) {
        this.sourcePosition = sourcePosition;
    }

    public Vector3Float getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Vector3Float targetPosition) {
        this.targetPosition = targetPosition;
    }
}
