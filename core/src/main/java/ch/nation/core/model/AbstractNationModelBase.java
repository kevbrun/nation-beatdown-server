package ch.nation.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public abstract class AbstractNationModelBase implements Serializable {

    private String name;

    private String uuid;

    private String description;

    public AbstractNationModelBase(String uuid) {
        this.uuid = uuid;
    }


    public AbstractNationModelBase() {
    }

    public AbstractNationModelBase(String uuid, String description) {
        this.uuid = uuid;
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

      public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractNationModelBase that = (AbstractNationModelBase) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }



    //Helper Functions

    @JsonIgnore
    public boolean isUuidValid(){

        return getUuid()!=null && !getUuid().isBlank();
    }

    @JsonIgnore
    public boolean isNameValid(){
        return getName()!=null && !getName().isBlank();
    }

}
