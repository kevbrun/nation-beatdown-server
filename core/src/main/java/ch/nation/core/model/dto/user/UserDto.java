package ch.nation.core.model.dto.user;

import ch.nation.core.model.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserDto extends AbstractDto implements Serializable {



    @JsonProperty("password")
    private String password;

    @JsonProperty("admin")
    private boolean isAdmin;


    @JsonProperty("nation")
    private NationDto nation;


    public UserDto(String password, boolean isAdmin, NationDto nation) {
        this.password = password;
        this.isAdmin = isAdmin;
        this.nation = nation;
    }


    public UserDto() {
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
