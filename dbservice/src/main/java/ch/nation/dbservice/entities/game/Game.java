package ch.nation.dbservice.entities.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.NationEntityBase;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Table(name="GAME")
@Entity(name="GAME")
public class Game extends NationEntityBase {


    @ManyToMany
    @Column(name="users")
    @JsonProperty("users")
    @RestResource(path = "users", rel="users")
    private List<User> users;

    @JsonProperty("round")
    @Column(name = "round")
    private int round;

    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    @Column(name = "stats")
    private GameStatus status;


    @OneToMany(
            mappedBy = "game",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @RestResource(path = "moves", rel="moves")
    private List<PlayerMoveAction> moves;


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


    public List<PlayerMoveAction> getMoves() {
        return moves;
    }

    public void setMoves(List<PlayerMoveAction> moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "game{" +
                "users=" + users +
                ", round=" + round +
                ", status=" + status +
                "} " + super.toString();
    }
}
