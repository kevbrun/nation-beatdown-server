package ch.nation.core.model.dto.user;

import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.unit.UnitDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class UserDto extends NamedObjectAbstractDto implements Serializable {



    @JsonProperty("password")
    private String password;

    @JsonProperty("nation")
    private NationDto nation;


    @JsonProperty("units")
    private List<UnitDto> units;

    @JsonProperty("role")
    private String role;




    public UserDto() {
    }

    @Override
    public String ResourceCollectionName() {
        return "users";
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public NationDto getNation() {
        return nation;
    }

    public void setNation(NationDto nation) {
        this.nation = nation;
    }

    public List<UnitDto> getUnits() {
        return units;
    }

    public void setUnits(List<UnitDto> units) {
        this.units = units;
    }

    // Helper Functions
    @JsonIgnore
    public boolean isPasswordValid() {
        return password!=null && !password.isBlank();
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "password='" + password + '\'' +
                ", role=" + role +
                ", nation=" + nation +
                "} " + super.toString();
    }
}
