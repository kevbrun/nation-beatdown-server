package ch.nation.dbservice.entities.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.moves.PlayerMoveAction;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name="GAME")
@Entity(name="GAME")
public class Game extends AbstractNationEntityBase {


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
        super();

    }

    public Game(List<User> users, int round, GameStatus status) {
        this.users = users;
        this.round = round;
        this.status = status;
    }


    public Game(List<User> users, int round, GameStatus status, List<PlayerMoveAction> moves) {
        this.users = users;
        this.round = round;
        this.status = status;
        this.moves = moves;
    }

    public List<User> getUsers() {
        if(users==null) users = new ArrayList<>();


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


    public List<PlayerMoveAction> getMoves(){
        if(moves==null)moves = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return round == game.round &&
                Objects.equals(users, game.users) &&
                status == game.status &&
                Objects.equals(moves, game.moves);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), users, round, status, moves);
    }
}
