package ch.nation.core.model;

import java.io.Serializable;

public abstract class AbstractNationModelBase implements Serializable {

    private String uuid;

    public AbstractNationModelBase(String uuid) {
        this.uuid = uuid;
    }


    public AbstractNationModelBase() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
