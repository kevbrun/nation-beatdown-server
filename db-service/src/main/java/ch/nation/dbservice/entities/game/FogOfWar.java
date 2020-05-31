package ch.nation.dbservice.entities.game;

import ch.nation.core.model.position.IVector3;
import ch.nation.dbservice.entities.SimpleIdEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "FOG_OF_WAR")
public class FogOfWar extends SimpleIdEntity implements IVector3<Float> {

    @JsonProperty("x")
    @Column(name = "x", precision = 5, scale = 5)
    private Float x;

    @Column(name = "y", precision = 5, scale = 5)
    @JsonProperty("y")
    private Float y;

    @Column(name = "z", precision = 5, scale = 5)
    @JsonProperty("z")
    private Float z;

    public FogOfWar() {
    }


    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getZ() {
        return z;
    }

    public void setZ(Float z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FogOfWar)) return false;
        FogOfWar fogOfWar = (FogOfWar) o;
        return Objects.equals(x, fogOfWar.x) &&
                Objects.equals(y, fogOfWar.y) &&
                Objects.equals(z, fogOfWar.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "FogOfWar{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
