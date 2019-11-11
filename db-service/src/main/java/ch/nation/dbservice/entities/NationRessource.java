package ch.nation.dbservice.entities;

import ch.nation.dbservice.entities.NamedEntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class NationRessource extends NamedEntityBase {


    @Column(name="identifier",unique = true,nullable = true,length = 50)
    @JsonProperty("ident")
    private String identifier;


    public NationRessource() {
    }

    public NationRessource(String name, String description, String identifier) {
        super(name, description);
        this.identifier = identifier;
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
        if (!(o instanceof NationRessource)) return false;
        if (!super.equals(o)) return false;
        NationRessource that = (NationRessource) o;
        return Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), identifier);
    }
}
