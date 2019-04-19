package ch.nation.core.model;

import java.io.Serializable;

public class UserModel extends AbstractNationModelBase implements Serializable {


    private String username;

    private String password;

    private boolean isAdmin;


    public UserModel(String uuid, String username, String password, boolean isAdmin) {
        super(uuid);
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserModel(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserModel(){
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (isAdmin != userModel.isAdmin) return false;
        if (!username.equals(userModel.username)) return false;
        return password.equals(userModel.password);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (isAdmin ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
