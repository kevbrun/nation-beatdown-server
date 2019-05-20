package ch.nation.core.model.position;

public class Vector3<T> {
    private T x;
    private T y;
    private T z;

    public Vector3(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3() {
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getZ() {
        return z;
    }

    public void setZ(T z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector3<?> vector3 = (Vector3<?>) o;

        if (getX() != null ? !getX().equals(vector3.getX()) : vector3.getX() != null) return false;
        if (getY() != null ? !getY().equals(vector3.getY()) : vector3.getY() != null) return false;
        return getZ() != null ? getZ().equals(vector3.getZ()) : vector3.getZ() == null;
    }

    @Override
    public int hashCode() {
        int result = getX() != null ? getX().hashCode() : 0;
        result = 31 * result + (getY() != null ? getY().hashCode() : 0);
        result = 31 * result + (getZ() != null ? getZ().hashCode() : 0);
        return result;
    }
}
