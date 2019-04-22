package ch.nation.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class UserModel extends AbstractNationModelBase implements Serializable {



    private String password;

    private boolean isAdmin;

    private NationModel nation;


    public UserModel(String password, boolean isAdmin, NationModel nation) {
        this.password = password;
        this.isAdmin = isAdmin;
        this.nation = nation;
    }

    public UserModel(){
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

    public NationModel getNation() {
        return nation;
    }

    public void setNation(NationModel nation) {
        this.nation = nation;
    }

    // Helper Functions
    @JsonIgnore
    public boolean isPasswordValid() {
        return password!=null && !password.isBlank();
    }


    @Override
    public String toString() {
        return "UserModel{" +
                "password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", nation=" + nation +
                "} " + super.toString();
    }
}
