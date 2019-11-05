package ch.nation.core.model.dto.names;

import ch.nation.core.model.Enums.Sex;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitFirstNameDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("sex")
    private Sex sex;

    public UnitFirstNameDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
