package ch.nation.dbservice.entities.names;

import ch.nation.core.model.Enums.Sex;
import ch.nation.dbservice.entities.SimpleIdEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UnitLastName  {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonProperty("last_name")
    @Column(name="last_name",unique = true,nullable = false)
    private String secondName;



    public UnitLastName() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof UnitLastName)) return false;
        UnitLastName that = (UnitLastName) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, secondName);
    }
}
