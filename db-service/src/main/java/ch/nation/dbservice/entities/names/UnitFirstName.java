package ch.nation.dbservice.entities.names;

import ch.nation.core.model.Enums.Sex;
import ch.nation.dbservice.entities.SimpleIdEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;


@Entity(name="UNIT_FIRST_NAMES")
public class UnitFirstName extends SimpleIdEntity {


    @Column(name="first_name",unique = true,nullable = false)
    @JsonProperty("first_name")
    private String firstName;


    @Column(name="sex")
    @JsonProperty("sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;


    public UnitFirstName() {
    }



    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



}
