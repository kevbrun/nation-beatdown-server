package ch.nation.core.model.position;

public class Vector3<T> implements IVector3<T> {
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

    @Override
    public T getX() {
        return x;
    }

    @Override
    public void setX(T x) {
        this.x = x;
    }

    @Override
    public T getY() {
        return y;
    }

    @Override
    public void setY(T y) {
        this.y = y;
    }

    @Override
    public T getZ() {
        return z;
    }

    @Override
    public void setZ(T z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {

        Vector3<T> vector3 = (Vector3<T>) o;
        if(this.getX()!=null || vector3.getX()!=null ||this.getX()!= vector3.getX()) return false;
        if(this.getY()!=null || vector3.getY()!=null ||this.getY()!= vector3.getY()) return false;
        if(this.getZ()!=null || vector3.getZ()!=null ||this.getZ()!= vector3.getZ()) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = getX() != null ? getX().hashCode() : 0;
        result = 31 * result + (getY() != null ? getY().hashCode() : 0);
        result = 31 * result + (getZ() != null ? getZ().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getX()+"|"+getY()+"|"+getZ();
    }
}
