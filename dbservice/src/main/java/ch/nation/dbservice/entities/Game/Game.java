package ch.nation.dbservice.entities.Game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.NationEntityBase;
import ch.nation.dbservice.entities.User.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Table(name="GAME")
@Entity(name="GAME")
public class Game extends NationEntityBase {


    @ManyToMany
    @Column(name="users")
    @JsonProperty("users")
    private List<User> users;

    @JsonProperty("round")
    @Column(name = "round")
    private int round;

    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    @Column(name = "stats")
    private GameStatus status;




    public Game() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Game{" +
                "users=" + users +
                ", round=" + round +
                ", status=" + status +
                "} " + super.toString();
    }
}