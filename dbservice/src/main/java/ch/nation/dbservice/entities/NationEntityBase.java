package ch.nation.dbservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class NationEntityBase extends AbstractNationEntityBase {


    @Column(name = "name",unique = true,nullable = false)
    @JsonProperty("name")
    private String name;
    @Column(name="desc")
    @JsonProperty("desc")
    private String description;

    public NationEntityBase(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public NationEntityBase() {
    }

    public NationEntityBase(String name){
        this.name = name;
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
        if (!(o instanceof NationEntityBase)) return false;
        NationEntityBase that = (NationEntityBase) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "NationEntityBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    //JPA Annoations


}
