package ch.nation.core.model.dto;

import com.fasterxml.jackson.annotation.*;



public abstract class NamedObjectAbstractDto extends AbstractDto {

    @JsonProperty("name")
    private String name;


    @JsonProperty("desc")
    private String description;


    public NamedObjectAbstractDto() {
        super();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamedObjectAbstractDto)) return false;

        NamedObjectAbstractDto that = (NamedObjectAbstractDto) o;

        if (!id.equals(that.id)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    public boolean isNameValid(){
        return getName()!=null && !getName().isBlank();
    }


    @Override
    public String toString() {
        return "AbstractDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
