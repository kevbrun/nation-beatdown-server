package ch.nation.dbservice.entities.units;

import ch.nation.core.model.position.IVector3;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class EmeddableVector3 implements IVector3<Float> {


    @JsonProperty("x")
    @Column(name="x",precision = 5,scale = 5)
    private Float x;

    @Column(name="y",precision = 5,scale = 5)
    @JsonProperty("y")
    private Float y;

    @Column(name="z",precision = 5,scale = 5)
    @JsonProperty("z")
    private Float z;


    public EmeddableVector3() {
    }

    public EmeddableVector3(Float x, Float y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Float getX() {
        return x;
    }

    @Override
    public void setX(Float x) {
        this.x = x;
    }

    @Override
    public Float getY() {
        return y;
    }

    @Override
    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public Float getZ() {
        return z;
    }

    @Override
    public void setZ(Float z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmeddableVector3)) return false;
        EmeddableVector3 that = (EmeddableVector3) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y) &&
                Objects.equals(z, that.z);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, z);
    }
}
