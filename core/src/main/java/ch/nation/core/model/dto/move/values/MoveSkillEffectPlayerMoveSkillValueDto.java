package ch.nation.core.model.dto.move.values;

import ch.nation.core.model.position.Vector3Float;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MoveSkillEffectPlayerMoveSkillValueDto extends BasePlayerMoveValueDto {


    @JsonProperty("source_pos")
    private Vector3Float sourcePosition;

    @JsonProperty("target_pos")
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


    @Override
    public String toString() {
        return "MoveSkillEffectPlayerMoveSkillValueDto{" +
                "sourcePosition=" + sourcePosition +
                ", targetPosition=" + targetPosition +
                "} " + super.toString();


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoveSkillEffectPlayerMoveSkillValueDto)) return false;
        if (!super.equals(o)) return false;
        MoveSkillEffectPlayerMoveSkillValueDto that = (MoveSkillEffectPlayerMoveSkillValueDto) o;
        return Objects.equals(sourcePosition, that.sourcePosition) &&
                Objects.equals(targetPosition, that.targetPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sourcePosition, targetPosition);
    }
}
