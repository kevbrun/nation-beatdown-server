package ch.nation.dbservice.entities.names;

import ch.nation.core.model.Enums.Sex;
import ch.nation.dbservice.entities.SimpleIdEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="UNIT_LAST_NAMES")
public class UnitLastName extends SimpleIdEntity {


    @JsonProperty("last_name")
    @Column(name="last_name",unique = true,nullable = false)
    private String secondName;



    public UnitLastName() {
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
        if (!super.equals(o)) return false;
        UnitLastName that = (UnitLastName) o;
        return Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), secondName);
    }
}
