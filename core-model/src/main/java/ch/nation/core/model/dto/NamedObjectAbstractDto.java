package ch.nation.core.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public abstract class NamedObjectAbstractDto extends AbstractDto {

    @JsonProperty("name")
    private String name;


    @JsonProperty("desc")
    private String description;

    @JsonProperty("ident")
    private String identifier;

    public NamedObjectAbstractDto() {
        super();

    }


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, identifier);
    }

    @Override
    public String toString() {
        return "NamedObjectAbstractDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
