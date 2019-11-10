package ch.nation.core.model.dto.names;

import ch.nation.core.model.Enums.Sex;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitLastNameDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("last_name")
    private String lastName;

    public UnitLastNameDto() {
    }

    public UnitLastNameDto(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

