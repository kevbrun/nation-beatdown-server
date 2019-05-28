package ch.nation.dbservice.entities.units;

import ch.nation.core.model.position.IVector3;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
}
