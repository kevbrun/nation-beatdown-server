package ch.nation.core.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class UserDto extends AbstractNationDto implements Serializable {



    private String password;

    private boolean isAdmin;

    private NationDto nation;


    public UserDto(String password, boolean isAdmin, NationDto nation) {
        this.password = password;
        this.isAdmin = isAdmin;
        this.nation = nation;
    }

    public UserDto(){
        super();
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
