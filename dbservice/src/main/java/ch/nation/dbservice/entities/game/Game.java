package ch.nation.dbservice.entities.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

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
    @Column(name = "status",nullable = false)
    private GameStatus gameStatus = GameStatus.None;


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
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    @RestResource(path = "moves", rel="moves")
    @JsonProperty("moves")
 //   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<BasePlayerMove> moves = new ArrayList<>();



    //ONE-TO-MANY????
    @OneToMany   // unidirectional
    @JoinTable(name="USER_GAME_RUNTIME_INFO",
            joinColumns=@JoinColumn(name="GAME"),
            inverseJoinColumns=@JoinColumn(name="GAME_INFO"))
    @MapKeyJoinColumn(name="USER")
    @JsonProperty("runtime")
    private Map<User,GameUserRuntimeInfo> userGameUserRuntimeInfoMap;


    public Game() {
        super();

    }

    public Game(List<User> users, int round, GameStatus gameStatus) {
        this.users = users;
        this.round = round;
        this.gameStatus = gameStatus;
    }


    public Game(List<User> users, int round, GameStatus gameStatus, List<BasePlayerMove> moves) {
        this.users = users;
        this.round = round;
        this.gameStatus = gameStatus;
        this.moves = moves;
    }

    public List<User> getUsers() {
        if(users==null) users = new ArrayList<>();


        return users;
    }



    public void setUsers(List<User> users) {
        LOGGER.info("Execute custom setter");

        if (this.users == null) {
            this.users = users;
        } else if(this.users != users) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.users.clear();
            if(users != null){
                this.users.addAll(users);
            }
        }


   //     this.users = users;
    }

    public Map<User, GameUserRuntimeInfo> getUserGameUserRuntimeInfoMap() {
        return userGameUserRuntimeInfoMap;
    }

    public void setUserGameUserRuntimeInfoMap(Map<User, GameUserRuntimeInfo> userGameUserRuntimeInfoMap) {
        this.userGameUserRuntimeInfoMap = userGameUserRuntimeInfoMap;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
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
        LOGGER.info("Execute custom getter");

        if(moves==null)moves = new ArrayList<>();
        return moves;
    }

    public void setMoves(List<BasePlayerMove> moves) {
        LOGGER.info("Execute custom setter");
        if (this.moves == null) {
            this.moves = moves;
        } else if(this.moves != moves) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.moves.clear();
            if(moves != null){
                this.moves.addAll(moves);
            }
        }


     //   this.moves = moves;
    }

    @Override
    public String toString() {
        return "game{" +
                "users=" + users +
                ", round=" + round +
                ", gameStatus=" + gameStatus +
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
                gameStatus == game.gameStatus &&
                Objects.equals(moves, game.moves);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), users, round, gameStatus, moves);
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

        for(BasePlayerMove move : moves){
            move.setGame(this);
        }


    }
}
