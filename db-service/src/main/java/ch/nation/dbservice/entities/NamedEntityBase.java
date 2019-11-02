package ch.nation.dbservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class NamedEntityBase extends AbstractNationEntityBase {


    @Column(name = "name",unique = true,nullable = false,length = 75)
    @JsonProperty("name")
    private String name;
    @Column(name="description") //Desc is keyword in maridb!
    @JsonProperty("desc")
    private String description;

    @Column(name="identifier",unique = false,nullable = true,length = 50)
    @JsonProperty("ident")
    private String identifier;

    public NamedEntityBase() {
    }

    public NamedEntityBase(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamedEntityBase)) return false;
        if (!super.equals(o)) return false;
        NamedEntityBase that = (NamedEntityBase) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, identifier);
    }
}
