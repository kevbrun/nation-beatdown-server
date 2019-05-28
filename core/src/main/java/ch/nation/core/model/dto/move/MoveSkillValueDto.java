package ch.nation.core.model.dto.move;

import ch.nation.core.model.position.Vector3Float;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoveSkillValueDto {


    @JsonProperty("source")
    private Vector3Float sourcePosition;

    @JsonProperty("target")
    private Vector3Float targetPosition;

    public MoveSkillValueDto(Vector3Float sourcePosition, Vector3Float targetPosition) {
        this.sourcePosition = sourcePosition;
        this.targetPosition = targetPosition;
    }


    public MoveSkillValueDto() {
    }

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



    @Override
    public String toString() {
        return "MoveSkillValueDto{" +
                "sourcePosition=" + sourcePosition +
                ", targetPosition=" + targetPosition +
                '}';
    }
}
