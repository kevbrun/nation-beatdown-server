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

@Table(name = "GAME")
@Entity(name = "GAME")
public class Game extends AbstractNationEntityBase {


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "games_users",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "users_id",
                    referencedColumnName = "id"))
    @Column(name = "players")
    @JsonProperty("users")
    @RestResource(path = "users", rel = "users")
    private List<User> users;

    @JsonProperty("round")
    @Column(name = "round")
    private int round;

    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    @Column(name = "status", nullable = false)
    private GameStatus gameStatus = GameStatus.None;


    @JsonProperty("current_player")
    @Column(name = "current_player", nullable = false)
    private String currentPlayerUuid;

    @JsonProperty("first_player")
    @Column(name = "first_player", nullable = false)
    private String firstPlayerUuid;

    @JsonProperty("next_player")
    @Column(name = "next_player", nullable = false)
    private String nextPlayerUuid;

    @JsonProperty("winner_player")
    @Column(name = "winner_player")
    private String winner;

    @OneToMany(
            mappedBy = "game",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @RestResource(path = "user-runtimes", rel = "user-runtimes", exported = true)
    @JsonProperty("runtimes")
    private List<GameUserRuntimeInfo> userRuntimeInfos;


    public Game() {
        super();

    }

    public Game(List<User> users, int round, GameStatus gameStatus) {
        this.users = users;
        this.round = round;
        this.gameStatus = gameStatus;
    }


    public List<User> getUsers() {
        if (users == null) users = new ArrayList<>();


        return users;
    }


    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
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
                Objects.equals(currentPlayerUuid, game.currentPlayerUuid) &&
                Objects.equals(firstPlayerUuid, game.firstPlayerUuid) &&
                Objects.equals(nextPlayerUuid, game.nextPlayerUuid) &&
                Objects.equals(userRuntimeInfos, game.userRuntimeInfos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), users, round, gameStatus, currentPlayerUuid, firstPlayerUuid, nextPlayerUuid, userRuntimeInfos);
    }


    //JPA

    public void addUser(User user) {
        if (!this.users.contains(user)) {
            this.users.add(user);
            user.addGame(this);
        }
    }

    public void removeUser(User user) {
        if (this.users.contains(user)) {
            this.users.remove(user);
            user.removeGame(this);
        }
    }


    public List<GameUserRuntimeInfo> getUserRuntimeInfos() {

        return userRuntimeInfos;
    }

    public void setUserRuntimeInfos(List<GameUserRuntimeInfo> userRuntimeInfos) {
        LOGGER.debug("Execute custom setter: setUserRuntimeInfos");

        if (this.userRuntimeInfos == null) {
            this.userRuntimeInfos = userRuntimeInfos;
        } else if (this.userRuntimeInfos != userRuntimeInfos) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.userRuntimeInfos.clear();
            if (userRuntimeInfos != null) {
                this.userRuntimeInfos.addAll(userRuntimeInfos);
            }
        }


    }

    public void addUserRuntimeInfos(GameUserRuntimeInfo info) {

        if (!userRuntimeInfos.contains(info)) {
            userRuntimeInfos.add(info);
            info.setGame(this);
        }
    }

    public void removeUserRuntimeInfos(GameUserRuntimeInfo info) {
        if (userRuntimeInfos.contains(info)) {
            userRuntimeInfos.remove(info);
            info.setGame(null);
        }
    }

    public void setUsers(List<User> users) {
        LOGGER.debug("Execute custom setter: setUsers");

        if (this.users == null) {
            this.users = users;
        } else if (this.users != users) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.users.clear();
            if (users != null) {
                this.users.addAll(users);
            }
        }


        //     this.users = users;
    }


    @PrePersist
    @PreUpdate
    public void prePersist() {
        for (User user :
                users) {
            user.addGame(this);


        }

        for (GameUserRuntimeInfo runtime : userRuntimeInfos) {
            runtime.setGame(this);
        }


    }
}
