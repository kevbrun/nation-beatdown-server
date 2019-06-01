package ch.nation.dbservice.entities.user;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.game.Game;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name="USER")
@Table(name="USER")
public class User extends NamedEntityBase implements Serializable {




    @Column(name="password",nullable = false)
    @JsonProperty("password")
    private String password;
    @Column(name="admin")
    @JsonProperty("admin")
    private boolean isAdmin;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @RestResource(path="nation",rel = "nation",exported = false)
    private Nation nation;

    @ManyToMany(mappedBy = "users")
    @RestResource(path = "games", rel="games")
    private List<Game> games;




    public User() {


        super();
        games = new ArrayList<>();

    }

    public User(String name, String description, String password, boolean isAdmin, Nation nation, List<Game> games) {
        super(name, description);
        this.password = password;
        this.isAdmin = isAdmin;
        this.nation = nation;
        this.games = games;
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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
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
