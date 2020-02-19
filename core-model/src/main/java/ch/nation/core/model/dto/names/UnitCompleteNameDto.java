package ch.nation.core.model.dto.names;

import ch.nation.core.model.Enums.Sex;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitCompleteNameDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("sex")
    private Sex sex;

    public UnitCompleteNameDto() {
    }


    public UnitCompleteNameDto(String firstName, String lastName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public UnitCompleteNameDto(UnitFirstNameDto firstNameDto, UnitLastNameDto lastNameDto) {
        this.firstName = firstNameDto.getFirstName();
        this.lastName = lastNameDto.getLastName();
        this.sex = firstNameDto.getSex();
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UnitCompleteNameDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
