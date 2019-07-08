package ch.nation.dbservice.entities.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
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


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "games_users",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "users_id",
                    referencedColumnName = "id"))
    @Column(name="users")
    @JsonProperty("users")
    @RestResource(path = "users", rel="users")
    private List<User> users = new ArrayList<>();

    @JsonProperty("round")
    @Column(name = "round")
    private int round;

    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    @Column(name = "stats")
    private GameStatus status;


    @JsonProperty("current_player")
    @Column(name="current_player",nullable = false)
    private String currentPlayerUuid;

    @JsonProperty("first_player")
    @Column(name="first_player",nullable = false)
    private String firstPlayerUuid;

    @JsonProperty("next_player")
    @Column(name="next_player",nullable = false)
    private String nextPlayerUuid;


    @OneToMany(
            mappedBy = "game",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @RestResource(path = "moves", rel="moves")
    private List<BasePlayerMove> moves = new ArrayList<>();


    public Game() {
        super();

    }

    public Game(List<User> users, int round, GameStatus status) {
        this.users = users;
        this.round = round;
        this.status = status;
    }


    public Game(List<User> users, int round, GameStatus status, List<BasePlayerMove> moves) {
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
        if (this.users == null) {
            this.users = users;
        } else if(this.users != users) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.users.clear();
            if(users != null){
                this.users.addAll(users);
            }
        }


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


    public String getCurrentPlayerUuid() {
        return currentPlayerUuid;
    }

    public void setCurrentPlayerUuid(String currentPlayerUuid) {
        this.currentPlayerUuid = currentPlayerUuid;
    }

    public String getFirstPlayerUuid() {
        return firstPlayerUuid;
    }

    public void setFirstPlayerUuid(String firstPlayerUuid) {
        this.firstPlayerUuid = firstPlayerUuid;
    }

    public String getNextPlayerUuid() {
        return nextPlayerUuid;
    }

    public void setNextPlayerUuid(String nextPlayerUuid) {
        this.nextPlayerUuid = nextPlayerUuid;
    }

    public List<BasePlayerMove> getMoves(){
        if(moves==null)moves = new ArrayList<>();
        return moves;
    }

    public void setMoves(List<BasePlayerMove> moves) {
        if (this.moves == null) {
            this.moves = moves;
        } else if(this.moves != moves) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.moves.clear();
            if(moves != null){
                this.moves.addAll(moves);
            }
        }


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


    //JPA

    public void addUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
            user.addGame(this);
        }
    }

    public void removeUser(User user){
        if(this.users.contains(user)){
            this.users.remove(user);
            user.removeGame(this);
        }
    }

    @PrePersist
    public void prePersist(){
        for (User user:
             users) {
            user.addGame(this);


        }


    }
}
