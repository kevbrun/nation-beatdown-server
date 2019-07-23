package ch.nation.dbservice.entities.moves.values;

import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.units.EmeddableVector3;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@DiscriminatorValue("MOVE")
@Entity(name="PLAYER_MOVE_SKILL_VALUE")
public class MoveSkillPlayerMoveValue extends BasePlayerMoveValue implements IDiscrimantorValue {

    @JsonProperty("source_pos")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "source_x")),
            @AttributeOverride(name = "y", column = @Column(name = "source_y")),
            @AttributeOverride(name = "z", column = @Column(name = "source_z")),
    })
    private EmeddableVector3 sourcePosition;

    @JsonProperty("target_pos")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "target_x")),
            @AttributeOverride(name = "y", column = @Column(name = "target_y")),
            @AttributeOverride(name = "z", column = @Column(name = "target_z")),


    })
    private EmeddableVector3 targetPosition;


    public MoveSkillPlayerMoveValue() {
    }

    public EmeddableVector3 getSourcePosition() {
        return sourcePosition;
    }

    public void setSourcePosition(EmeddableVector3 sourcePosition) {
        this.sourcePosition = sourcePosition;
    }

    public EmeddableVector3 getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(EmeddableVector3 targetPosition) {
        this.targetPosition = targetPosition;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoveSkillPlayerMoveValue)) return false;
        if (!super.equals(o)) return false;
        MoveSkillPlayerMoveValue that = (MoveSkillPlayerMoveValue) o;
        return Objects.equals(sourcePosition, that.sourcePosition) &&
                Objects.equals(targetPosition, that.targetPosition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), sourcePosition, targetPosition);
    }

    @Override
    public String toString() {
        return "MoveSkillPlayerMoveValue{" +
                "sourcePosition=" + sourcePosition +
                ", targetPosition=" + targetPosition +
                "} " + super.toString();
    }
}
