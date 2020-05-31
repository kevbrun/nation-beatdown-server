package ch.nation.dbservice.entities.vectors;

import ch.nation.core.model.position.IVector3;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class EmbeddableVector3Int implements IVector3<Integer> {
    private int x;
    private int y;
    private int z;

    public EmbeddableVector3Int() {
    }


    @Override
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbeddableVector3Int that = (EmbeddableVector3Int) o;
        return x == that.x &&
                y == that.y &&
                z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
