package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.units.EmeddableVector3;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name="MOVE_SKILL_VALUE")
@DiscriminatorValue("MOVE")
public class MoveSkillValue extends MoveValue {

    @JsonProperty("source")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "source_x")),
            @AttributeOverride(name = "y", column = @Column(name = "source_y")),
            @AttributeOverride(name = "z", column = @Column(name = "source_z")),


    })
    private EmeddableVector3 sourcePosition;

    @JsonProperty("target")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "target_x")),
            @AttributeOverride(name = "y", column = @Column(name = "target_y")),
            @AttributeOverride(name = "z", column = @Column(name = "target_z")),


    })
    private EmeddableVector3 targetPosition;

    public MoveSkillValue(EmeddableVector3 sourcePosition, EmeddableVector3 targetPosition) {
        this.sourcePosition = sourcePosition;
        this.targetPosition = targetPosition;
    }

    public MoveSkillValue() {
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
    public String toString() {
        return "MoveSkillValue{" +
                "sourcePosition=" + sourcePosition +
                ", targetPosition=" + targetPosition +
                "} " + super.toString();
    }
}
