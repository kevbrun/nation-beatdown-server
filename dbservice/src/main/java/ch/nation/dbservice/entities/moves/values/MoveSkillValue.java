package ch.nation.dbservice.entities.moves.values;

import ch.nation.dbservice.entities.units.EmeddableVector3;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

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
        super();

    }

    public EmeddableVector3 getSourcePosition() {


        if(sourcePosition==null) sourcePosition = new EmeddableVector3();
        return sourcePosition;
    }

    public void setSourcePosition(EmeddableVector3 sourcePosition) {
        this.sourcePosition = sourcePosition;
    }

    public EmeddableVector3 getTargetPosition() {

        targetPosition = new EmeddableVector3();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoveSkillValue)) return false;
        if (!super.equals(o)) return false;
        MoveSkillValue that = (MoveSkillValue) o;
        return Objects.equals(sourcePosition, that.sourcePosition) &&
                Objects.equals(targetPosition, that.targetPosition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), sourcePosition, targetPosition);
    }
}
