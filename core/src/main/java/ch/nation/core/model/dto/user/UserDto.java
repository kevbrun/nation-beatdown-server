package ch.nation.core.model.dto.user;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.unit.UnitDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class UserDto extends AbstractDto implements Serializable {



    @JsonProperty("password")
    private String password;

    @JsonProperty("admin")
    private boolean isAdmin;


    @JsonProperty("nation")
    private NationDto nation;


    @JsonProperty("units")
    private List<UnitDto> units;


    public UserDto(String password, boolean isAdmin, NationDto nation) {
        this.password = password;
        this.isAdmin = isAdmin;
        this.nation = nation;
    }


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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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
                ", isAdmin=" + isAdmin +
                ", nation=" + nation +
                "} " + super.toString();
    }
}
