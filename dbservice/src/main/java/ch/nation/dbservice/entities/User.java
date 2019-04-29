package ch.nation.dbservice.entities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="User")
public class User extends NationEntityBase implements Serializable {




    @Column(nullable = false)
    private String password;
    @Column
    private boolean isAdmin;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @RestResource(path="nation",rel = "nation")
    private Nation nation;


    public User(UUID id, String name, String description, String password, boolean isAdmin, Nation nation) {
        super(id, name, description);
        this.password = password;
        this.isAdmin = isAdmin;
        this.nation = nation;
    }

    public User(String password, boolean isAdmin, Nation nation) {
        this.password = password;
        this.isAdmin = isAdmin;
        this.nation = nation;
    }

    public User(String username,String password){
        super(username);
        this.password =password;

    }


    public User() {
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

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return isAdmin == user.isAdmin &&

                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), password, isAdmin);
    }
}
